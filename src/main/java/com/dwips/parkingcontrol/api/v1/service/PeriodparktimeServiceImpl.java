package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodparktime;
import com.dwips.parkingcontrol.api.v1.dto.PeriodparktimeRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TperiodparktimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodparktimeServiceImpl implements PeriodparktimeService{

    private final TperiodparktimeRepository tperiodparktimeRepository;

    @Override
    public HashMap<String, Object> search(PeriodparktimeRequestDto periodparktimeRequestDto) {

        Integer result = 0;

        List<Tperiodparktime> tperiodparktimeList = tperiodparktimeRepository.findAllBySitenumAndGroupnum(
                periodparktimeRequestDto.getSitenum(),
                periodparktimeRequestDto.getGroupnum()
        );

        if(!tperiodparktimeList.isEmpty()){
            result = 1;
        }else{
            tperiodparktimeList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tperiodparktime",tperiodparktimeList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(PeriodparktimeRequestDto periodparktimeRequestDto) {

        Integer result = 0;
        List<Tperiodparktime> tperiodparktimeList = new ArrayList<>();

        tperiodparktimeList.add(tperiodparktimeRepository.save(periodparktimeRequestDto.getTperiodparktime()));

        if(!tperiodparktimeList.isEmpty()){
            result = 1;
        }else{
            tperiodparktimeList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tperiodparktime",tperiodparktimeList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(PeriodparktimeRequestDto periodparktimeRequestDto) {

        Integer result = 0;
        List<Tperiodparktime> tperiodparktimeList = new ArrayList<>();

        Tperiodparktime tperiodparktime = tperiodparktimeRepository.findBySitenumAndGroupnumAndXindex(
                periodparktimeRequestDto.getSitenum(),
                periodparktimeRequestDto.getGroupnum(),
                periodparktimeRequestDto.getTperiodparktime().getXindex()
        );

        if(tperiodparktime!=null){
            tperiodparktimeRepository.save(periodparktimeRequestDto.getTperiodparktime());
            tperiodparktimeList.add(tperiodparktime);
            result = 1;
        }else{
            tperiodparktimeList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tperiodparktime",tperiodparktimeList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(PeriodparktimeRequestDto periodparktimeRequestDto) {
        Integer result = 0;
        Tperiodparktime tperiodparktime = null;

        if(periodparktimeRequestDto.getXindex()!=null){
            tperiodparktime = tperiodparktimeRepository.findBySitenumAndGroupnumAndXindex(
                    periodparktimeRequestDto.getSitenum(),
                    periodparktimeRequestDto.getGroupnum(),
                    periodparktimeRequestDto.getXindex()
            );
        }else if(periodparktimeRequestDto.getCode()!=null){
            tperiodparktime = tperiodparktimeRepository.findBySitenumAndGroupnumAndCode(
                    periodparktimeRequestDto.getSitenum(),
                    periodparktimeRequestDto.getGroupnum(),
                    periodparktimeRequestDto.getCode()
            );
        }

        if(tperiodparktime!=null){
            tperiodparktimeRepository.delete(tperiodparktime);
            result = 1;
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
