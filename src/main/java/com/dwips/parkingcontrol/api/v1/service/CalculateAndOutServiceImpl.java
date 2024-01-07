package com.dwips.parkingcontrol.api.v1.service;

/*
∴ tbcardinfo 및 tdiscountinfo 는 없을 경우 생략가능 tparkinfo 는 index 조회 후 필요 정보 update 및 index 가 없을 경우 insert 합니다.
∴ tparkinfo 테이블에 outflag 에 입차시는 73 일반정산은 88 출차시는 79 로 구분 합니다.
∴ 차량조회정산 쿼리 후 등록차량인 경우 tperiodinout 정보를 보내면 차량번호를 기 본 키로 하여 tperiodmember 의 outflag 를 79로 업데이트,
tperiodinout outflag 가 73 인 레코드를 찾아 출차 정보 및 outflag 79 로 업데이트 없을 경우 인서트,
로컬쪽에서 보낼때 입차정보가 없기 때문에 입차 정보는 출차 정보와 동일 하므로 레코드가 있을 경 우 반드시 출차정보만 업데이트 해야 함
 */

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.*;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;
import com.dwips.parkingcontrol.api.v1.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CalculateAndOutServiceImpl implements CalculateAndOutService{

    private final TparkinfoRepository tparkinfoRepository;
    private final TbcardinfoRepository tbcardinfoRepository;
    private final TdiscountinfoRepository tdiscountinfoRepository;
    private final TperiodinoutRespository tperiodinoutRespository;
    private final TperiodmemberRespository tperiodmemberRespository;

    @Override
    @Transactional
    public HashMap<String,Object> calculate(CalculateAndOutRequestDto calculateAndOutRequestDto) {
        //정산

        Integer result = 0;

        // 요청 데이터에서 tparkinfo 가 없으면 무시
        if(calculateAndOutRequestDto.getTparkinfo() != null){

            //검색 : tparkinfo 의 차량번호로 tparkinfo 에 입차 outflag 73 차량이 있는지 검사
            Tparkinfo tparkinfo = tparkinfoRepository.findBySitenumAndGroupnumAndIndevicenumAndCarnumAndOutflag(
                    calculateAndOutRequestDto.getTparkinfo().getSitenum(),
                    calculateAndOutRequestDto.getTparkinfo().getGroupnum(),
                    calculateAndOutRequestDto.getTparkinfo().getIndevicenum(),
                    calculateAndOutRequestDto.getTparkinfo().getCarnum(),
                    73L);

            if(tparkinfo != null){
                //있으면 outflag 88 처리 (정산) 처리
                tparkinfo.setOutflag(88L);
                tparkinfoRepository.save(tparkinfo);

            }else{
                //없으면 tparkinfo 에 데이터 insert 하여 우선 입차 처리
                Tparkinfo insertTparkinfo = calculateAndOutRequestDto.getTparkinfo();
                tparkinfo = tparkinfoRepository.save(insertTparkinfo);

            }

            //tbcardinfo 있으면 insert
            if(calculateAndOutRequestDto.getTbcardinfo() != null){

                Tbcardinfo requestTbcardinfo = calculateAndOutRequestDto.getTbcardinfo();

                requestTbcardinfo.setPindex(tparkinfo.getXindex());

                tbcardinfoRepository.save(requestTbcardinfo);
            }

            //tdiscountinfo 있으면 insert
            if(calculateAndOutRequestDto.getTdiscountinfo() != null){

                Tdiscountinfo requestTdiscountinfo  = calculateAndOutRequestDto.getTdiscountinfo();

                requestTdiscountinfo.setPindex(tparkinfo.getXindex());

                tdiscountinfoRepository.save(requestTdiscountinfo);
            }

            result = 2;

        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    @Transactional
    public HashMap<String,Object> out(CalculateAndOutRequestDto calculateAndOutRequestDto) {
        //출차

        Integer result = 0;

        if(calculateAndOutRequestDto.getTparkinfo() != null){
            //일반차량

            Tparkinfo tparkinfo = tparkinfoRepository.findBySitenumAndGroupnumAndIndevicenumAndCarnumAndOutflag(
                    calculateAndOutRequestDto.getTparkinfo().getSitenum(),
                    calculateAndOutRequestDto.getTparkinfo().getGroupnum(),
                    calculateAndOutRequestDto.getTparkinfo().getIndevicenum(),
                    calculateAndOutRequestDto.getTparkinfo().getCarnum(),
                    88L);

            LocalDateTime today = LocalDateTime.now();
            if(calculateAndOutRequestDto.getTparkinfo().getOutdatetime() != null){
                today = calculateAndOutRequestDto.getTparkinfo().getOutdatetime();
            }

            if(tparkinfo != null) {
                tparkinfo.setOutflag(79L);
                tparkinfo.setOutdatetime(today);
                tparkinfoRepository.save(tparkinfo);
                result = 2;
            }

        }else if(calculateAndOutRequestDto.getTperiodinout() != null){
            //등록차량

            Tperiodinout tperiodinout = tperiodinoutRespository.findBySitenumAndGroupnumAndIndevicenumAndCarnumAndOutflag(
                    calculateAndOutRequestDto.getTperiodinout().getSitenum(),
                    calculateAndOutRequestDto.getTperiodinout().getGroupnum(),
                    calculateAndOutRequestDto.getTperiodinout().getIndevicenum(),
                    calculateAndOutRequestDto.getTperiodinout().getCarnum(),
                    73L);

            Tperiodmember tperiodmember = tperiodmemberRespository.findBySitenumAndGroupnumAndDevicenumAndCarnumAndUseyn(
                    calculateAndOutRequestDto.getTperiodinout().getSitenum(),
                    calculateAndOutRequestDto.getTperiodinout().getGroupnum(),
                    calculateAndOutRequestDto.getTperiodinout().getIndevicenum(),
                    calculateAndOutRequestDto.getTperiodinout().getCarnum(),
                    "y"
            );

            if(tperiodinout != null && tperiodmember != null){
                tperiodinout.setOutflag(79L);
                tperiodinoutRespository.save(tperiodinout);
            }else if(tperiodinout == null && tperiodmember != null){
                Tperiodinout insertTperiodinout = calculateAndOutRequestDto.getTperiodinout();
                tperiodinoutRespository.save(insertTperiodinout);
            }


            if(tperiodmember != null){
                tperiodmember.setOutflag(79L);
                tperiodmemberRespository.save(tperiodmember);
                result = 1;
            }
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;

    }
}
