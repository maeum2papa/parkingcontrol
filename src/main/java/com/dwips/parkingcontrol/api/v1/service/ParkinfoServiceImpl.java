package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TparkinfoCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TparkinfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ParkinfoServiceImpl implements ParkinfoService{

    private final CommonComponent commonComponent;

    private final TparkinfoRepository tparkinfoRepository;

    private final TparkinfoCustomRepository tparkinfoCustomRepository;


    @Override
    public HashMap<String, Object> search(ParkinfoRequestDto parkinfoRequestDto) {

        Integer result = 0;

        HashMap<String,Object> resultMap = new HashMap<>();

        List<Tparkinfo> tparkinfoList = tparkinfoCustomRepository.customFindAll(
                parkinfoRequestDto.getSitenum(),
                parkinfoRequestDto.getGroupnum(),
                parkinfoRequestDto.getDevicenum(),
                parkinfoRequestDto.getMname(),
                parkinfoRequestDto.getXindex(),
                parkinfoRequestDto.getCarnum(),
                commonComponent.stringDateToLocalDateTime(parkinfoRequestDto.getDatefrom(), "from"),
                commonComponent.stringDateToLocalDateTime(parkinfoRequestDto.getDateto(), "to"),
                parkinfoRequestDto.getQtype()
        );

        if(!tparkinfoList.isEmpty()){
            result = 1;
        }else{
            tparkinfoList = null;
        }

        resultMap.put("result",result);
        resultMap.put("tparkinfo",tparkinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ParkinfoRequestDto parkinfoRequestDto) {

        Integer result = 0;

        List<Tparkinfo> tparkinfoList = new ArrayList<>();

        tparkinfoList.add(tparkinfoRepository.save(parkinfoRequestDto.getTparkinfo()));

        if(!tparkinfoList.isEmpty()){
            result = 1;
        }else{
            tparkinfoList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkinfo",tparkinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ParkinfoRequestDto parkinfoRequestDto) {

        Integer result = 0;

        List<Tparkinfo> tparkinfoList = new ArrayList<>();

        Tparkinfo tparkinfo = tparkinfoRepository.findBySitenumAndGroupnumAndXindex(
                parkinfoRequestDto.getSitenum(),
                parkinfoRequestDto.getGroupnum(),
                parkinfoRequestDto.getTparkinfo().getXindex()
        );

        if(tparkinfo != null) {
            tparkinfoRepository.save(parkinfoRequestDto.getTparkinfo());
            tparkinfoList.add(tparkinfo);
            result = 1;
        }else{
            tparkinfoList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkinfo",tparkinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(ParkinfoRequestDto parkinfoRequestDto) {

        Integer result = 0;

        Tparkinfo tparkinfo = tparkinfoRepository.findBySitenumAndGroupnumAndXindex(
                parkinfoRequestDto.getSitenum(),
                parkinfoRequestDto.getGroupnum(),
                parkinfoRequestDto.getXindex()
        );

        if(tparkinfo != null){
            tparkinfoRepository.delete(tparkinfo);
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        return resultMap;
    }
}
