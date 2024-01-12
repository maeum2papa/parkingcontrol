package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tparkfee;
import com.dwips.parkingcontrol.api.v1.dto.ParkfeeRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TparkfeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkfeeServiceImpl implements ParkfeeService{

    private final TparkfeeRepository tparkfeeRepository;

    @Override
    public HashMap<String, Object> search(ParkfeeRequestDto parkfeeRequestDto) {

        Integer result = 0;

        List<Tparkfee> parkfeeList = tparkfeeRepository.findAllBySitenumAndGroupnum(
                parkfeeRequestDto.getSitenum(),
                parkfeeRequestDto.getGroupnum()
        );

        if(!parkfeeList.isEmpty()){
            result = 1;
        }else{
            parkfeeList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("parkfee",parkfeeList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ParkfeeRequestDto parkfeeRequestDto) {

        Integer result = 0;

        List<Tparkfee> parkfeeList = new ArrayList<>();

        parkfeeList.add(tparkfeeRepository.save(parkfeeRequestDto.getTparkfee()));

        if(!parkfeeList.isEmpty()){
            result = 1;
        }else{
            parkfeeList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("parkfee",parkfeeList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ParkfeeRequestDto parkfeeRequestDto) {

        Integer result = 0;

        List<Tparkfee> parkfeeList = new ArrayList<>();

        Tparkfee tparkfee = tparkfeeRepository.findBySitenumAndGroupnumAndXindex(
                parkfeeRequestDto.getSitenum(),
                parkfeeRequestDto.getGroupnum(),
                parkfeeRequestDto.getTparkfee().getXindex()
        );

        if(tparkfee != null){
            Tparkfee updateTparkfee = tparkfeeRepository.save(parkfeeRequestDto.getTparkfee());
            parkfeeList.add(updateTparkfee);
            result = 1;
        }else{
            parkfeeList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("parkfee",parkfeeList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(ParkfeeRequestDto parkfeeRequestDto) {

        Integer result = 0;

        Tparkfee tparkfee = tparkfeeRepository.findBySitenumAndGroupnumAndXindex(
                parkfeeRequestDto.getSitenum(),
                parkfeeRequestDto.getGroupnum(),
                parkfeeRequestDto.getXindex()
        );

        if(tparkfee != null){
            tparkfeeRepository.delete(tparkfee);
            result = 1;
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
