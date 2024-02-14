package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkings;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkingRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkingResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ParkingController {

    private final CommonComponent commonComponent;

    private final ParkingService parkingService;

    @GetMapping("/parkings")
    public ParkingResponseDto search(@ModelAttribute ParkingRequestDto parkingRequestDto){

        commonComponent.logJson("주차장 검색 요청",parkingRequestDto);

        HashMap<String,Object> result = parkingService.search(parkingRequestDto);

        ParkingResponseDto response = ParkingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkings((List<Tparkings>) result.get("tparkings"))
                .build();


        commonComponent.logJson("주차장 검색 응답",response);

        return response;
    }

}
