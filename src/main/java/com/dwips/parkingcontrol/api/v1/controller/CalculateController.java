package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.dto.CalculateRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;
import com.dwips.parkingcontrol.api.v1.service.CalculateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CalculateController {

    private final CalculateService calculateService;

    @PostMapping("/calculate")
    public CalculateResponseDto calculate(@RequestBody CalculateRequestDto calculateRequestDto){

        log.info("정산(출차) : {}",calculateRequestDto.toString());

        if(!calculateRequestDto.getIOTYPE().equals("C")){
            throw new RuntimeException("정산 정보가 아닙니다.");
        }

        return calculateService.calculate(calculateRequestDto);

    }

}
