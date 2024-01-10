package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tparkingnum;
import com.dwips.parkingcontrol.api.v1.dto.ParkingnumRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TparkinfoRepository;
import com.dwips.parkingcontrol.api.v1.repository.TparkingnumRepository;
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
public class ParkingnumServiceImpl implements ParkingnumService{

    private final TparkingnumRepository tparkingnumRepository;

    @Override
    public HashMap<String, Object> search(ParkingnumRequestDto parkingnumRequestDto) {

        Integer result = 0;
        List<Tparkingnum> tparkingnumList = null;

        if(parkingnumRequestDto.getGroupnum()!=null){
            tparkingnumList = tparkingnumRepository.findAllBySitenumAndGroupnum(
                    parkingnumRequestDto.getSitenum(),
                    parkingnumRequestDto.getGroupnum()
            );
        }else{
            tparkingnumList = tparkingnumRepository.findAllBySitenum(
                    parkingnumRequestDto.getSitenum()
            );
        }

        if(!tparkingnumList.isEmpty()){
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkingnum",tparkingnumList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ParkingnumRequestDto parkingnumRequestDto) {

        Integer result = 0;
        List<Tparkingnum> tparkingnumList = new ArrayList<>();

        Tparkingnum tparkingnum = tparkingnumRepository.findBySitenumAndGroupnumAndXindex(
                parkingnumRequestDto.getSitenum(),
                parkingnumRequestDto.getGroupnum(),
                parkingnumRequestDto.getTparkingnum().getXindex()
        );

        if(tparkingnum!=null) {
            tparkingnumRepository.save(parkingnumRequestDto.getTparkingnum());
            tparkingnumList.add(tparkingnum);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkingnum",tparkingnumList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ParkingnumRequestDto parkingnumRequestDto) {

        Integer result = 0;
        List<Tparkingnum> tparkingnumList = new ArrayList<>();

        tparkingnumList.add(tparkingnumRepository.save(parkingnumRequestDto.getTparkingnum()));

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkingnum",tparkingnumList);

        return resultMap;
    }
}
