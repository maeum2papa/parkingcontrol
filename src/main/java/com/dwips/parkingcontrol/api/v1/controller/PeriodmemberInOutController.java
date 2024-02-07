package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberInOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberInOutResponseDto;
import com.dwips.parkingcontrol.api.v1.service.PeriodmemberInOutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PeriodmemberInOutController {
    private final CommonComponent commonComponent;
    private final PeriodmemberInOutService periodmemberInOutService;

    @GetMapping("/periodmemberinout")
    public PeriodmemberInOutResponseDto search(@RequestBody PeriodmemberInOutRequestDto periodmemberInOutRequestDto){


        commonComponent.logJson("등록된 차량의 입출차 내역 조회 요청",periodmemberInOutRequestDto);

        HashMap<String, Object> result = periodmemberInOutService.search(periodmemberInOutRequestDto);

        PeriodmemberInOutResponseDto response = PeriodmemberInOutResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodinout((List<Tperiodinout>) result.get("tperiodinout"))
                .build();

        commonComponent.logJson("등록된 차량의 입출차 내역 조회 응답",response);

        return response;
    }

}
