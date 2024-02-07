package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final DeviceinfoService deviceinfoService;

    @GetMapping("/deviceinfo")
    public DeviceinfoResponseDto search(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        commonComponent.logJson("장치리스트 조회 요청",deviceinfoRequestDto);

        HashMap<String, Object> result = deviceinfoService.search(deviceinfoRequestDto);

        DeviceinfoResponseDto response = DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdeviceinfo((List<Tdeviceinfo>) result.get("deviceinfo"))
                .build();

        commonComponent.logJson("장치리스트 조회 응답",response);

        return response;

    }


    @PostMapping("/deviceinfo")
    public DeviceinfoResponseDto save(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        commonComponent.logJson("장치리스트 등록 요청",deviceinfoRequestDto);

        HashMap<String, Object> result = deviceinfoService.save(deviceinfoRequestDto);
        System.out.println("result = " + result);

        DeviceinfoResponseDto response = DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdeviceinfo((List<Tdeviceinfo>) result.get("deviceinfo"))
                .build();

        commonComponent.logJson("장치리스트 등록 응답",response);

        return response;
    }

    @PutMapping("/deviceinfo")
    public DeviceinfoResponseDto update(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        commonComponent.logJson("장치리스트 수정 요청",deviceinfoRequestDto);

        HashMap<String, Object> result = deviceinfoService.update(deviceinfoRequestDto);
        System.out.println("result = " + result);

        DeviceinfoResponseDto response = DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdeviceinfo((List<Tdeviceinfo>) result.get("deviceinfo"))
                .build();

        commonComponent.logJson("장치리스트 수정 응답",response);

        return response;
    }

    @DeleteMapping("/deviceinfo")
    public DeviceinfoResponseDto delete(@RequestBody DeviceinfoRequestDto deviceinfoRequestDto){

        commonComponent.logJson("장치리스트 삭제 요청",deviceinfoRequestDto);

        HashMap<String, Object> result = deviceinfoService.delete(deviceinfoRequestDto);
        System.out.println("result = " + result);

        DeviceinfoResponseDto response = DeviceinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("장치리스트 삭제 응답",response);

        return response;
    }
}
