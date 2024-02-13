package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodparktime;
import com.dwips.parkingcontrol.api.v1.dto.PeriodparktimeRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodparktimeResponseDto;
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

    private final CommonComponent commonComponent;
    private final PeriodparktimeService periodparktimeService;

    @GetMapping("/periodparktime")
    public PeriodparktimeResponseDto search(@ModelAttribute PeriodparktimeRequestDto periodparktimeRequestDto){

        commonComponent.logJson("정기권 주차시간 테이블 조회 요청",periodparktimeRequestDto);

        HashMap<String,Object> result = periodparktimeService.search(periodparktimeRequestDto);

        PeriodparktimeResponseDto response = PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodparktime((List<Tperiodparktime>) result.get("tperiodparktime"))
                .build();

        commonComponent.logJson("정기권 주차시간 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/periodparktime")
    public PeriodparktimeResponseDto save(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){

        commonComponent.logJson("정기권 주차시간 테이블 등록 요청",periodparktimeRequestDto);

        HashMap<String,Object> result = periodparktimeService.save(periodparktimeRequestDto);

        PeriodparktimeResponseDto response = PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodparktime((List<Tperiodparktime>) result.get("tperiodparktime"))
                .build();

        commonComponent.logJson("정기권 주차시간 테이블 등록 응답",response);

        return response;
    }

    @PutMapping("/periodparktime")
    public PeriodparktimeResponseDto update(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){

        commonComponent.logJson("정기권 주차시간 테이블 수정 요청",periodparktimeRequestDto);

        HashMap<String,Object> result = periodparktimeService.update(periodparktimeRequestDto);

        PeriodparktimeResponseDto response = PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodparktime((List<Tperiodparktime>) result.get("tperiodparktime"))
                .build();

        commonComponent.logJson("정기권 주차시간 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/periodparktime")
    public PeriodparktimeResponseDto delete(@RequestBody PeriodparktimeRequestDto periodparktimeRequestDto){


        commonComponent.logJson("정기권 주차시간 테이블 삭제 요청",periodparktimeRequestDto);

        HashMap<String,Object> result = periodparktimeService.delete(periodparktimeRequestDto);

        PeriodparktimeResponseDto response = PeriodparktimeResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("정기권 주차시간 테이블 삭제 응답",response);

        return response;
    }


}
