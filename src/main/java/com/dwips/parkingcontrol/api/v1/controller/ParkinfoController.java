package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.dto.ParkfeeRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ParkinfoController {

    private final CommonComponent commonComponent;

    private final ParkinfoService parkinfoService;

    @GetMapping("/parkinfo")
    public ParkinfoResponseDto search(@ModelAttribute ParkinfoRequestDto parkinfoRequestDto){

        commonComponent.logJson("일반차량 검색 요청",parkinfoRequestDto);

        HashMap<String,Object> result = parkinfoService.search(parkinfoRequestDto);

        ParkinfoResponseDto response = ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .build();


        commonComponent.logJson("일반차량 검색 응답",response);

        return response;
    }

    @PostMapping("/parkinfo")
    public ParkinfoResponseDto save(@RequestBody ParkinfoRequestDto parkinfoRequestDto) {

        commonComponent.logJson("일반차량 등록 요청",parkinfoRequestDto);

        HashMap<String,Object> result = parkinfoService.save(parkinfoRequestDto);

        ParkinfoResponseDto response = ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .build();

        commonComponent.logJson("일반차량 등록 응답",response);

        return response;
    }

    @PutMapping("/parkinfo")
    public ParkinfoResponseDto update(@RequestBody ParkinfoRequestDto parkinfoRequestDto) {

        commonComponent.logJson("일반차량 수정 요청",parkinfoRequestDto);


        HashMap<String,Object> result = parkinfoService.update(parkinfoRequestDto);

        ParkinfoResponseDto response = ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .build();

        commonComponent.logJson("일반차량 수정 응답",response);

        return response;
    }

    @DeleteMapping("/parkinfo")
    public ParkinfoResponseDto delete(@RequestBody ParkinfoRequestDto parkinfoRequestDto) {
        commonComponent.logJson("일반차량 삭제 요청",parkinfoRequestDto);

        HashMap<String,Object> result = parkinfoService.delete(parkinfoRequestDto);

        ParkinfoResponseDto response = ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();


        commonComponent.logJson("일반차량 삭제 응답",response);

        return response;
    }

}
