package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final PeriodaccountService periodaccountService;

    @GetMapping("/periodaccount")
    public PeriodaccountResponseDto search(@RequestBody PeriodaccountRequestDto periodaccountRequestDto){


        commonComponent.logJson("등록차량 매출 내역 조회 요청",periodaccountRequestDto);

        HashMap<String,Object> result = periodaccountService.search(periodaccountRequestDto);

        PeriodaccountResponseDto response = PeriodaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodaccount((List<Tperiodaccount>) result.get("tperiodaccount"))
                .build();

        commonComponent.logJson("등록차량 매출 내역 조회 응답",response);

        return response;
    }

    @PostMapping("/periodaccount")
    public PeriodaccountResponseDto save(@RequestBody PeriodaccountRequestDto periodaccountRequestDto){

        commonComponent.logJson("등록차량 매출 내역 등록 요청",periodaccountRequestDto);

        HashMap<String,Object> result = periodaccountService.save(periodaccountRequestDto);


        PeriodaccountResponseDto response = PeriodaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodaccount((List<Tperiodaccount>) result.get("tperiodaccount"))
                .build();


        commonComponent.logJson("등록차량 매출 내역 등록 응답",response);

        return response;
    }

}
