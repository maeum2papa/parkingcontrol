package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.*;
import com.dwips.parkingcontrol.api.v1.dto.CalculateRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;
import com.dwips.parkingcontrol.api.v1.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
∴ 4자리 검색 후 등록차량 및 일반차량의 데이터를 보내면 됨. 등록차량의 경우 무인기 에서 기간 연장을 할 수 있어야 하므로 필요. 일반차량의 경우 요금정산을 수행하기 위해 기존 정산 내역이 있는 경우 그 데이터도 포함 하여 보내야 함.
∴ 일반차량의 경우 정산을 한 후 시간이 지나 출차를 하지 않을 경우 추가 요금을 징수하여야 하기 때문에 기존 결제 내역이 필요함.
∴ 사전에 관리자가 할인차량에 대한 복지카드 및 기타 정보를 입력하여 정산시에 자동으로 할인을 해주기 위한 welfare 테이블이 필요함.
∴ 차량번호가 없을 경우 전체 출차 하지 않은 모든 데이터
∴ tparkinfo 의 xindex tbcardinfo 와 tdiscountinfo 의 pindex(외래키) 오 조인 결과 welfare 는 차량번호 로 조인
 */

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CalculateSerivceImpl  implements CalculateService{

    private final CommonComponent commonComponent;

    private final TparkinfoRepository tparkinfoRepository;
    private final TperiodinoutRespository tperiodinoutRespository;

    private final TperiodmemberRespository tperiodmemberRespository;

    private final TwelfareRepository twelfareRepository;
    private final TbcardinfoRepository tbcardinfoRepository;
    private final TdiscountinfoRepository tdiscountinfoRepository;

    @Override
    public HashMap<String,Object> calculate(CalculateRequestDto calculateRequestDto) {

        Integer result = 0;

        List<Tparkinfo> tparkinfoList = null;
        List<List<Tbcardinfo>> tbcardinfoList = new ArrayList<>();
        List<List<Tdiscountinfo>> tdiscountinfoList = new ArrayList<>();
        List<List<Twelfare>>  twelfareList = new ArrayList<>();

        List<Tperiodinout> tperiodinoutList = null;

        Tperiodmember tperiodmember = null;

        //등록차량 정보 검색
        tperiodmember = tperiodmemberRespository.findBySitenumAndGroupnumAndDevicenumAndCarnumAndUseyn(
                calculateRequestDto.getSitenum(),
                calculateRequestDto.getGroupnum(),
                calculateRequestDto.getDevicenum(),
                calculateRequestDto.getCarnum(),
                "y");

        if (tperiodmember != null) {
            result = 1;

        }else{

            if(calculateRequestDto.getCarnum() == null){
                //차량번호 없는 경우

                //일반차량(n개)
                tparkinfoList = tparkinfoRepository.findAllBySitenumAndGroupnumAndOutflag(
                        calculateRequestDto.getSitenum(),
                        calculateRequestDto.getGroupnum(),
                        73L);

            }else {

                String carnum = "";

                if(calculateRequestDto.getCarnum().length() == 4) {
                    //4자리만 입력한 경우
                    carnum = "%"+calculateRequestDto.getCarnum();

                }else{
                    //모두 입력한 경우
                    carnum = calculateRequestDto.getCarnum();
                }


                //일반차량(n개)
                tparkinfoList = tparkinfoRepository.findAllBySitenumAndGroupnumAndCarnumLikeAndOutflag(
                        calculateRequestDto.getSitenum(),
                        calculateRequestDto.getGroupnum(),
                        carnum,
                        73L);
            }

            if(tparkinfoList.size() != 0) {
                result = 2;
            }else{
                tparkinfoList = null;
            }
        }


        if(tparkinfoList != null){

            for(Tparkinfo tparkinfo: tparkinfoList){
                List<Tbcardinfo> tbcardinfo = tbcardinfoRepository.findAllByPindex(tparkinfo.getXindex());
                List<Tdiscountinfo> tdiscountinfo = tdiscountinfoRepository.findAllByPindex(tparkinfo.getXindex());
                List<Twelfare> twelfares = twelfareRepository.findAllByCarnumAndStarddateLessThanEqualAndEnddateGreaterThanEqual(tparkinfo.getCarnum(), LocalDate.now(), LocalDate.now());


                if(tbcardinfo.size() != 0) tbcardinfoList.add(tbcardinfo);
                if(tdiscountinfo.size() != 0) tdiscountinfoList.add(tdiscountinfo);
                if(twelfares.size() != 0) twelfareList.add(twelfares);
            }

        }

        if(tbcardinfoList.size() == 0) tbcardinfoList = null;
        if(tdiscountinfoList.size() == 0) tdiscountinfoList = null;
        if(twelfareList.size() == 0) twelfareList = null;


        HashMap<String, Object> responseMap = new HashMap<>();

        responseMap.put("result",result);
        responseMap.put("tparkinfo",tparkinfoList);
        responseMap.put("tbcardinfo",tbcardinfoList);
        responseMap.put("tdiscountinfo",tdiscountinfoList);
        responseMap.put("welfare",twelfareList);
        responseMap.put("tperiodmember",tperiodmember);

        return responseMap;

    }
}
