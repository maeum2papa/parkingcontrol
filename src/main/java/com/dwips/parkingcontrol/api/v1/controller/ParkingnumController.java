package com.dwips.parkingcontrol.api.v1.controller;


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

    private final ParkingnumService parkingnumService;

    @GetMapping("/parkingnum")
    public ParkingnumResponseDto search(@RequestBody ParkingnumRequestDto parkingnumRequestDto){

        log.info("주차장 차량 입출차 대수 조회 : {}",parkingnumRequestDto.toString());

        HashMap<String, Object> result = parkingnumService.search(parkingnumRequestDto);

        return ParkingnumResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkingnum((List<Tparkingnum>) result.get("tparkingnum"))
                .build();
    }

    @PostMapping("/parkingnum")
    public ParkingnumResponseDto save(@RequestBody ParkingnumRequestDto parkingnumRequestDto){

        log.info("주차장 차량 입출차 대수 등록 : {}",parkingnumRequestDto.toString());

        HashMap<String, Object> result = parkingnumService.save(parkingnumRequestDto);

        return ParkingnumResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkingnum((List<Tparkingnum>) result.get("tparkingnum"))
                .build();
    }

    @PutMapping("/parkingnum")
    public ParkingnumResponseDto update(@RequestBody ParkingnumRequestDto parkingnumRequestDto){

        log.info("주차장 차량 입출차 대수 수정 : {}",parkingnumRequestDto.toString());

        HashMap<String, Object> result = parkingnumService.update(parkingnumRequestDto);

        return ParkingnumResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkingnum((List<Tparkingnum>) result.get("tparkingnum"))
                .build();
    }

}
