package com.dwips.parkingcontrol.api.v1.controller;


import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkingnum;
import com.dwips.parkingcontrol.api.v1.dto.ParkingnumRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkingnumResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkingnumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ParkingnumController {

    private final CommonComponent commonComponent;

    private final ParkingnumService parkingnumService;

    @GetMapping("/parkingnum")
    public ParkingnumResponseDto search(@ModelAttribute ParkingnumRequestDto parkingnumRequestDto){


        commonComponent.logJson("주차장 차량 입출차 대수 조회 요청",parkingnumRequestDto);

        HashMap<String, Object> result = parkingnumService.search(parkingnumRequestDto);

        ParkingnumResponseDto response = ParkingnumResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkingnum((List<Tparkingnum>) result.get("tparkingnum"))
                .build();

        commonComponent.logJson("주차장 차량 입출차 대수 조회 응답",response);

        return response;
    }

    @PostMapping("/parkingnum")
    public ParkingnumResponseDto save(@RequestBody ParkingnumRequestDto parkingnumRequestDto){


        commonComponent.logJson("주차장 차량 입출차 대수 등록 요청",parkingnumRequestDto);

        HashMap<String, Object> result = parkingnumService.save(parkingnumRequestDto);

        ParkingnumResponseDto response = ParkingnumResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkingnum((List<Tparkingnum>) result.get("tparkingnum"))
                .build();

        commonComponent.logJson("주차장 차량 입출차 대수 조회 응답",response);

        return response;
    }

    @PutMapping("/parkingnum")
    public ParkingnumResponseDto update(@RequestBody ParkingnumRequestDto parkingnumRequestDto){


        commonComponent.logJson("주차장 차량 입출차 대수 수정 요청",parkingnumRequestDto);

        HashMap<String, Object> result = parkingnumService.update(parkingnumRequestDto);

        ParkingnumResponseDto response = ParkingnumResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkingnum((List<Tparkingnum>) result.get("tparkingnum"))
                .build();

        commonComponent.logJson("주차장 차량 입출차 대수 수정 응답",response);

        return response;
    }

}
