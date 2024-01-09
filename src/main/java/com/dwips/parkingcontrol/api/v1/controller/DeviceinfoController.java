package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tdeviceinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.DeviceinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DeviceinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DeviceinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DeviceinfoController {

    private final DeviceinfoService deviceinfoService;

    @GetMapping("/deviceinfo")
    public DeviceinfoResponseDto search(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        log.info("장치리스트 조회 : {}",deviceinfoRequestDto.toString());

        HashMap<String, Object> result = deviceinfoService.search(deviceinfoRequestDto);
        System.out.println("result = " + result);

        return DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdeviceinfo((List<Tdeviceinfo>) result.get("deviceinfo"))
                .build();
    }


    @PostMapping("/deviceinfo")
    public DeviceinfoResponseDto save(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        log.info("장치리스트 등록 : {}",deviceinfoRequestDto.toString());

        HashMap<String, Object> result = deviceinfoService.save(deviceinfoRequestDto);
        System.out.println("result = " + result);

        return DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdeviceinfo((List<Tdeviceinfo>) result.get("deviceinfo"))
                .build();
    }

    @PutMapping("/deviceinfo")
    public DeviceinfoResponseDto update(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        log.info("장치리스트 수정 : {}",deviceinfoRequestDto.toString());

        HashMap<String, Object> result = deviceinfoService.update(deviceinfoRequestDto);
        System.out.println("result = " + result);

        return DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdeviceinfo((List<Tdeviceinfo>) result.get("deviceinfo"))
                .build();
    }

    @DeleteMapping("/deviceinfo")
    public DeviceinfoResponseDto delete(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        log.info("장치리스트 삭제 : {}",deviceinfoRequestDto.toString());

        HashMap<String, Object> result = deviceinfoService.delete(deviceinfoRequestDto);
        System.out.println("result = " + result);

        return DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }
}
