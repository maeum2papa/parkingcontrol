package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tlogon;
import com.dwips.parkingcontrol.api.v1.dto.LogonRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TlogonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogonServiceImpl implements LogonService{

    private final CommonComponent commonComponent;
    private final TlogonRepository tlogonRepository;

    @Override
    public HashMap<String, Object> search(LogonRequestDto logonRequestDto) {

        Integer result = 0;
        List<Tlogon> tlogonList = new ArrayList<>();

        if(logonRequestDto.getDevicenum()==null){
            tlogonList = tlogonRepository.findAllBySitenumAndGroupnumAndLogdatetimeGreaterThanEqualAndLogdatetimeLessThanEqual(
                    logonRequestDto.getSitenum(),
                    logonRequestDto.getGroupnum(),
                    commonComponent.stringDateToLocalDateTime(logonRequestDto.getDatefrom(),"from"),
                    commonComponent.stringDateToLocalDateTime(logonRequestDto.getDateto(),"to")
            );
        }else{
            tlogonList = tlogonRepository.findAllBySitenumAndGroupnumAndDevicenumAndLogdatetimeGreaterThanEqualAndLogdatetimeLessThanEqual(
                    logonRequestDto.getSitenum(),
                    logonRequestDto.getGroupnum(),
                    logonRequestDto.getDevicenum(),
                    commonComponent.stringDateToLocalDateTime(logonRequestDto.getDatefrom(),"from"),
                    commonComponent.stringDateToLocalDateTime(logonRequestDto.getDateto(),"to")
            );
        }

        if(!tlogonList.isEmpty()){
            result = 1;
        }else{
            tlogonList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tlogon",tlogonList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(LogonRequestDto logonRequestDto) {

        Integer result = 0;
        List<Tlogon> tlogonList = new ArrayList<>();

        tlogonList.add(tlogonRepository.save(logonRequestDto.getTlogon()));

        if(!tlogonList.isEmpty()){
            result = 1;

        }else{
            tlogonList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tlogon",tlogonList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(LogonRequestDto logonRequestDto) {

        Integer result = 0;

        Tlogon tlogon = tlogonRepository.findBySitenumAndGroupnumAndXindex(
                logonRequestDto.getSitenum(),
                logonRequestDto.getGroupnum(),
                logonRequestDto.getXindex()
        );

        if(tlogon!=null){
            result = 1;
            tlogonRepository.delete(tlogon);
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("xindex",tlogon.getXindex());

        return resultMap;
    }
}
