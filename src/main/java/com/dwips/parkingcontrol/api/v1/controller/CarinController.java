package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;
import com.dwips.parkingcontrol.api.v1.service.CarinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CarinController {

    private final CommonComponent commonComponent;

    private final CarinService carinService;

    //차량입차
    @PostMapping("/carin")
    public CarinResponseDto carIn(@RequestBody CarinRequestDto carinRequestDto){

        commonComponent.logJson("차량입차 요청",carinRequestDto);

        if(!carinRequestDto.getIOTYPE().equals("I")){
            throw new RuntimeException("입차 정보가 아닙니다.");
        }


        HashMap<Object, Object> result = carinService.saveCar(carinRequestDto);


        CarinResponseDto response = CarinResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((Tparkinfo) result.get("tparkinfo"))
                .tperiodmember((Tperiodmember) result.get("tperiodmember"))
                .build();

        commonComponent.logJson("차량입차 응답",response);

        return response;
    }

}
