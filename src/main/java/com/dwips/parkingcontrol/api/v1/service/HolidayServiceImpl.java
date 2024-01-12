package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tholiday;
import com.dwips.parkingcontrol.api.v1.dto.HolidayRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TholidayCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TholidayRepository;
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
public class HolidayServiceImpl implements HolidayService{

    private final CommonComponent commonComponent;

    private final TholidayRepository tholidayRepository;

    private final TholidayCustomRepository tholidayCustomRepository;


    @Override
    public HashMap<String, Object> search(HolidayRequestDto holidayRequestDto) {

        Integer result = 0;

        List<Tholiday> tholidayList = tholidayCustomRepository.customFindAll(
                holidayRequestDto.getSitenum(),
                holidayRequestDto.getGroupnum(),
                commonComponent.stringDateToLocalDate(holidayRequestDto.getYear() + "-01-01"),
                commonComponent.stringDateToLocalDate(holidayRequestDto.getYear() + "-12-31")
        );

        if(!tholidayList.isEmpty()){
            result = 1;
        }else{
            tholidayList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tholiday",tholidayList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(HolidayRequestDto holidayRequestDto) {
        Integer result = 0;
        List<Tholiday> tholidayList = new ArrayList<>();

        tholidayList.add(tholidayRepository.save(holidayRequestDto.getTholiday()));

        if(!tholidayList.isEmpty()){
            result = 1;
        }else{
            tholidayList = null;
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tholiday",tholidayList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(HolidayRequestDto holidayRequestDto) {
        Integer result = 0;
        List<Tholiday> tholidayList = new ArrayList<>();

        Tholiday tholiday = tholidayRepository.findBySitenumAndGroupnumAndXindex(
                holidayRequestDto.getSitenum(),
                holidayRequestDto.getGroupnum(),
                holidayRequestDto.getTholiday().getXindex()
        );

        if(tholiday!=null){
            result = 1;
            tholidayRepository.save(holidayRequestDto.getTholiday());
            tholidayList.add(tholiday);
        }else{
            tholidayList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tholiday",tholidayList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(HolidayRequestDto holidayRequestDto) {
        Integer result = 0;

        Tholiday tholiday = tholidayRepository.findBySitenumAndGroupnumAndXindex(
                holidayRequestDto.getSitenum(),
                holidayRequestDto.getGroupnum(),
                holidayRequestDto.getXindex()
        );

        if(tholiday!=null){
            result = 1;
            tholidayRepository.delete(tholiday);
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
