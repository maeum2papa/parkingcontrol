package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkunpaied;
import com.dwips.parkingcontrol.api.v1.dto.ParkunpaiedRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TparkunpaiedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkunpaiedServiceImpl implements ParkunpaiedService{

    private final CommonComponent commonComponent;

    private final TparkunpaiedRepository tparkunpaiedRepository;

    @Override
    public HashMap<String, Object> search(ParkunpaiedRequestDto parkunpaiedRequestDto) {
        Integer result = 0;
        List<Tparkunpaied> tparkunpaiedList = new ArrayList<>();

        if(parkunpaiedRequestDto.getCarnum()!=null && parkunpaiedRequestDto.getDevicenum()!=null){

            tparkunpaiedList = tparkunpaiedRepository.findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqualAndCarnumAndDevicenum(
                    parkunpaiedRequestDto.getSitenum(),
                    parkunpaiedRequestDto.getGroupnum(),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDatefrom(),"from"),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDateto(),"to"),
                    parkunpaiedRequestDto.getCarnum(),
                    parkunpaiedRequestDto.getDevicenum()
            );

        }else if(parkunpaiedRequestDto.getCarnum()!=null && parkunpaiedRequestDto.getDevicenum()==null){

            tparkunpaiedList = tparkunpaiedRepository.findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqualAndCarnum(
                    parkunpaiedRequestDto.getSitenum(),
                    parkunpaiedRequestDto.getGroupnum(),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDatefrom(),"from"),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDateto(),"to"),
                    parkunpaiedRequestDto.getCarnum()
            );

        }else if(parkunpaiedRequestDto.getCarnum()==null && parkunpaiedRequestDto.getDevicenum()!=null){
            tparkunpaiedList = tparkunpaiedRepository.findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqualAndDevicenum(
                    parkunpaiedRequestDto.getSitenum(),
                    parkunpaiedRequestDto.getGroupnum(),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDatefrom(),"from"),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDateto(),"to"),
                    parkunpaiedRequestDto.getDevicenum()
            );
        }else{
            tparkunpaiedList = tparkunpaiedRepository.findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqual(
                    parkunpaiedRequestDto.getSitenum(),
                    parkunpaiedRequestDto.getGroupnum(),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDatefrom(),"from"),
                    commonComponent.stringDateToLocalDateTime(parkunpaiedRequestDto.getDateto(),"to")
            );
        }

        if(!tparkunpaiedList.isEmpty()){
            result = 1;
        }else{
            tparkunpaiedList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tparkunpaied",tparkunpaiedList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ParkunpaiedRequestDto parkunpaiedRequestDto) {
        Integer result = 0;
        List<Tparkunpaied> tparkunpaiedList = new ArrayList<>();
        Tparkinfo tparkinfo = new Tparkinfo();

        tparkunpaiedList.add(tparkunpaiedRepository.save(parkunpaiedRequestDto.getTparkunpaied()));

        if(!tparkunpaiedList.isEmpty()){
            result = 1;
        }else{
            tparkunpaiedList = null;
            tparkinfo = null;
        }


        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tparkunpaied",tparkunpaiedList);
        resultMap.put("tparkinfo",tparkinfo);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(ParkunpaiedRequestDto parkunpaiedRequestDto) {
        Integer result = 0;

        Tparkunpaied tparkunpaied = tparkunpaiedRepository.findBySitenumAndGroupnumAndXindex(
            parkunpaiedRequestDto.getSitenum(),
            parkunpaiedRequestDto.getGroupnum(),
            parkunpaiedRequestDto.getXindex()
        );

        if(tparkunpaied!=null){
            tparkunpaiedRepository.delete(tparkunpaied);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("xindex",tparkunpaied.getXindex());

        return resultMap;
    }
}
