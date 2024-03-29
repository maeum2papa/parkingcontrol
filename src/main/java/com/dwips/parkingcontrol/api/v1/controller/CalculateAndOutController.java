package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;
import com.dwips.parkingcontrol.api.v1.service.CalculateAndOutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CalculateAndOutController {

    private final CommonComponent commonComponent;

    private final CalculateAndOutService calculateAndOutService;

    @PostMapping("/calculateandout")
    public CalculateAndOutResponseDto calculateandout(@RequestBody CalculateAndOutRequestDto calculateAndOutRequestDto){


        commonComponent.logJson("정산 & 출차 저장 요청",calculateAndOutRequestDto);

        HashMap<String, Object> result = new HashMap<>();

        if(calculateAndOutRequestDto.getIOTYPE().equals("U")) {
            //정산

            result = calculateAndOutService.calculate(calculateAndOutRequestDto);

        }else if(calculateAndOutRequestDto.getIOTYPE().equals("O")){
            //출차

            result = calculateAndOutService.out(calculateAndOutRequestDto);

        }else{
            throw new RuntimeException("정산(또는 출차) 정보가 아닙니다.");
        }


        CalculateAndOutResponseDto response = CalculateAndOutResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("정산 & 출차 저장 응답",response);

        return response;
    }
}
