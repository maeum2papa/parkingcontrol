package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tdeviceinfo;
import com.dwips.parkingcontrol.api.v1.dto.DeviceinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TdeviceinfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DeviceinfoServiceImpl implements DeviceinfoService{

    private final TdeviceinfoRepository tdeviceinfoRepository;

    @Override
    public HashMap<String, Object> search(DeviceinfoRequestDto deviceinfoRequestDto) {

        Integer result = 0;
        List<Tdeviceinfo> deviceinfoList = tdeviceinfoRepository.findAllBySitenumAndGroupnum(
                deviceinfoRequestDto.getSitenum(),
                deviceinfoRequestDto.getGroupnum()
        );

        HashMap<String, Object> resultMap = new HashMap<>();

        if(deviceinfoList.isEmpty()){
            deviceinfoList = null;
        }else{
            result = 1;
        }

        resultMap.put("result",result);
        resultMap.put("deviceinfo",deviceinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(DeviceinfoRequestDto deviceinfoRequestDto) {

        List<Tdeviceinfo> deviceinfoList = new ArrayList<>();
        deviceinfoList.add(tdeviceinfoRepository.save(deviceinfoRequestDto.getTdeviceinfo()));

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",1);
        resultMap.put("deviceinfo",deviceinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(DeviceinfoRequestDto deviceinfoRequestDto) {
        Integer result = 0;
        List<Tdeviceinfo> deviceinfoList = null;

        Tdeviceinfo requetTdeviceinfo = deviceinfoRequestDto.getTdeviceinfo();
        Tdeviceinfo tdeviceinfo = tdeviceinfoRepository.findBySitenumAndGroupnumAndXindex(
                requetTdeviceinfo.getSitenum(),
                requetTdeviceinfo.getGroupnum(),
                requetTdeviceinfo.getXindex()
        );

        if(tdeviceinfo != null) {
            deviceinfoList.add(tdeviceinfoRepository.save(deviceinfoRequestDto.getTdeviceinfo()));
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("deviceinfo",deviceinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(DeviceinfoRequestDto deviceinfoRequestDto) {

        Integer result = 0;
        Tdeviceinfo tdeviceinfo = tdeviceinfoRepository.findBySitenumAndGroupnumAndXindex(
                deviceinfoRequestDto.getSitenum(),
                deviceinfoRequestDto.getGroupnum(),
                deviceinfoRequestDto.getXindex()
        );

        if(tdeviceinfo != null){
            tdeviceinfoRepository.delete(tdeviceinfo);
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
