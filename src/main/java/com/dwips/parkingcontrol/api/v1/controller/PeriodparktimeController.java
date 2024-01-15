package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodparktime;
import com.dwips.parkingcontrol.api.v1.repository.PeriodparktimeRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.PeriodparktimeResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DeviceinfoService;
import com.dwips.parkingcontrol.api.v1.service.PeriodparktimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PeriodparktimeController {

    private final PeriodparktimeService periodparktimeService;

    @GetMapping("/periodparktime")
    public PeriodparktimeResponseDto search(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){

        log.info("정기권 주차시간 테이블 조회 : {}",periodparktimeRequestDto.toString());

        HashMap<String,Object> result = periodparktimeService.search(periodparktimeRequestDto);

        return PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodparktime((List<Tperiodparktime>) result.get("tperiodparktime"))
                .build();
    }

    @PostMapping("/periodparktime")
    public PeriodparktimeResponseDto save(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){

        log.info("정기권 주차시간 테이블 등록 : {}",periodparktimeRequestDto.toString());

        HashMap<String,Object> result = periodparktimeService.save(periodparktimeRequestDto);

        return PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodparktime((List<Tperiodparktime>) result.get("tperiodparktime"))
                .build();
    }

    @PutMapping("/periodparktime")
    public PeriodparktimeResponseDto update(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){

        log.info("정기권 주차시간 테이블 수정 : {}",periodparktimeRequestDto.toString());

        HashMap<String,Object> result = periodparktimeService.update(periodparktimeRequestDto);

        return PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodparktime((List<Tperiodparktime>) result.get("tperiodparktime"))
                .build();
    }

    @DeleteMapping("/periodparktime")
    public PeriodparktimeResponseDto delete(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){

        log.info("정기권 주차시간 테이블 삭제 : {}",periodparktimeRequestDto.toString());

        HashMap<String,Object> result = periodparktimeService.delete(periodparktimeRequestDto);

        return PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }


}
