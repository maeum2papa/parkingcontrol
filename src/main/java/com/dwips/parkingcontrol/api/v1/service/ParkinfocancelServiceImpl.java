package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfocancelRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TbcardinfoRepository;
import com.dwips.parkingcontrol.api.v1.repository.TparkinfoRepository;
import com.dwips.parkingcontrol.api.v1.repository.TperiodmemberRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ParkinfocancelServiceImpl implements ParkinfocancelService{

    private final CommonComponent commonComponent;

    private final TbcardinfoRepository tbcardinfoRepository;
    private final TparkinfoRepository tparkinfoRepository;
    private final TperiodmemberRespository tperiodmemberRespository;

    @Override
    public HashMap<String, Object> search(ParkinfocancelRequestDto parkinfocancelRequestDto) {

        Integer result = 0;

        List<Tbcardinfo> tbcardinfoList = new ArrayList<>();
        List<Tparkinfo> tparkinfoList = new ArrayList<>();
        List<Tperiodmember> tperiodmemberList = new ArrayList<>();

        if(parkinfocancelRequestDto.getAcceptnum()!=null){

            tbcardinfoList = tbcardinfoRepository.findAllBySitenumAndGroupnumAndAcceptnum(
                    parkinfocancelRequestDto.getSitenum(),
                    parkinfocancelRequestDto.getGroupnum(),
                    parkinfocancelRequestDto.getAcceptnum()
            );


        }else if(parkinfocancelRequestDto.getCarnum()!=null){

            String carnum = (parkinfocancelRequestDto.getCarnum().length()==4)?
                    "%"+parkinfocancelRequestDto.getCarnum()
            :
                    parkinfocancelRequestDto.getCarnum()
            ;

            tbcardinfoList = tbcardinfoRepository.findAllBySitenumAndGroupnumAndCarnumAndOutdatetimeLessThanEqualAndOutdatetimeGreaterThanEqual(
                parkinfocancelRequestDto.getSitenum(),
                parkinfocancelRequestDto.getGroupnum(),
                parkinfocancelRequestDto.getCarnum(),
                commonComponent.stringDateToLocalDateTime(parkinfocancelRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(parkinfocancelRequestDto.getDateto(),"to")
            );

        }


        if(!tbcardinfoList.isEmpty()){
            result = 1;

            for (Tbcardinfo tbcardinfo : tbcardinfoList) {

                if(tbcardinfo.getCredittype()==0){
                    //일반권
                    Long tparkinfoXindex = tbcardinfo.getPindex();

                    tparkinfoList.addAll(tparkinfoRepository.findAllById(Collections.singleton(tparkinfoXindex)));

                }else if(tbcardinfo.getCredittype()==1){
                    //정기권
                    Long tperiodmemberXindex = tbcardinfo.getPindex();

                    tperiodmemberList.addAll(tperiodmemberRespository.findAllById(Collections.singleton(tperiodmemberXindex)));

                }

            }

        }else{

            tbcardinfoList = null;

        }

        if(tparkinfoList.isEmpty()){
            tparkinfoList = null;
        }

        if(tperiodmemberList.isEmpty()){
            tperiodmemberList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tbcardinfo",tbcardinfoList);
        resultMap.put("tparkinfo",tparkinfoList);
        resultMap.put("tperiodmember",tperiodmemberList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ParkinfocancelRequestDto parkinfocancelRequestDto) {
        Integer result = 0;

        Tparkinfo tparkinfo = tparkinfoRepository.findBySitenumAndGroupnumAndXindex(
                parkinfocancelRequestDto.getSitenum(),
                parkinfocancelRequestDto.getGroupnum(),
                parkinfocancelRequestDto.getTparkinfo().getXindex()
        );

        if(tparkinfo!=null){

            tparkinfoRepository.save(parkinfocancelRequestDto.getTparkinfo()); //update
            tbcardinfoRepository.save(parkinfocancelRequestDto.getTbcardinfo()); //insert

            result = 1;

        }


        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("xindex",tparkinfo.getXindex());

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ParkinfocancelRequestDto parkinfocancelRequestDto) {
        Integer result = 0;

        Tparkinfo tparkinfo = tparkinfoRepository.findBySitenumAndGroupnumAndXindex(
                parkinfocancelRequestDto.getSitenum(),
                parkinfocancelRequestDto.getGroupnum(),
                parkinfocancelRequestDto.getTparkinfo().getXindex()
        );

        if(tparkinfo!=null){

            tparkinfoRepository.save(parkinfocancelRequestDto.getTparkinfo()); //update
            tbcardinfoRepository.save(parkinfocancelRequestDto.getTbcardinfo()); //insert

            result = 1;

        }


        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("xindex",tparkinfo.getXindex());

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(ParkinfocancelRequestDto parkinfocancelRequestDto) {
        Integer result = 0;

        Tbcardinfo tbcardinfo = tbcardinfoRepository.findBySitenumAndGroupnumAndXindex(
                parkinfocancelRequestDto.getSitenum(),
                parkinfocancelRequestDto.getGroupnum(),
                parkinfocancelRequestDto.getXindex()
        );

        if(tbcardinfo!=null){

            tbcardinfoRepository.delete(tbcardinfo);

            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("xindex",parkinfocancelRequestDto.getXindex());

        return resultMap;
    }
}
