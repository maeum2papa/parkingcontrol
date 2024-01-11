package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import com.dwips.parkingcontrol.api.v1.dto.PeriodaccountRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodaccountResponseDto;
import com.dwips.parkingcontrol.api.v1.service.PeriodaccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PeriodaccountController {

    private final PeriodaccountService periodaccountService;

    @GetMapping("/periodaccount")
    public PeriodaccountResponseDto search(@RequestBody PeriodaccountRequestDto periodaccountRequestDto){

        log.info("등록차량 매출 내역 조회 : {}",periodaccountRequestDto.toString());


        HashMap<String,Object> result = periodaccountService.search(periodaccountRequestDto);

        return PeriodaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodaccount((List<Tperiodaccount>) result.get("tperiodaccount"))
                .build();
    }

    @PostMapping("/periodaccount")
    public PeriodaccountResponseDto save(@RequestBody PeriodaccountRequestDto periodaccountRequestDto){

        log.info("등록차량 매출 내역 등록 : {}",periodaccountRequestDto.toString());

        HashMap<String,Object> result = periodaccountService.save(periodaccountRequestDto);


        return PeriodaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodaccount((List<Tperiodaccount>) result.get("tperiodaccount"))
                .build();
    }

}
