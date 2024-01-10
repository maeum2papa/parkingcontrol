package com.dwips.parkingcontrol.api.v1.controller;

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

    private final ParkinfoService parkinfoService;

    @GetMapping("/parkinfo")
    public ParkinfoResponseDto search(@RequestBody ParkinfoRequestDto parkinfoRequestDto){

        log.info("일반차량 검색 : {}",parkinfoRequestDto.toString());

        HashMap<String,Object> result = parkinfoService.search(parkinfoRequestDto);

        return ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .build();
    }

    @PostMapping("/parkinfo")
    public ParkinfoResponseDto save(@RequestBody ParkinfoRequestDto parkinfoRequestDto) {
        log.info("일반차량 검색 : {}",parkinfoRequestDto.toString());

        HashMap<String,Object> result = parkinfoService.save(parkinfoRequestDto);

        return ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .build();
    }

    @PutMapping("/parkinfo")
    public ParkinfoResponseDto update(@RequestBody ParkinfoRequestDto parkinfoRequestDto) {
        log.info("일반차량 검색 : {}",parkinfoRequestDto.toString());

        HashMap<String,Object> result = parkinfoService.update(parkinfoRequestDto);

        return ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .build();
    }

    @DeleteMapping("/parkinfo")
    public ParkinfoResponseDto delete(@RequestBody ParkinfoRequestDto parkinfoRequestDto) {
        log.info("일반차량 삭제 : {}",parkinfoRequestDto.toString());

        HashMap<String,Object> result = parkinfoService.delete(parkinfoRequestDto);

        return ParkinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
