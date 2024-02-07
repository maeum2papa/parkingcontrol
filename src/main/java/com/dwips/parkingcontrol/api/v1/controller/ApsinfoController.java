package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.dto.ApsinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ApsinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ApsinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ApsinfoController {

    private final CommonComponent commonComponent;

    private final ApsinfoService apsinfoService;

    @PostMapping("/apsinfo")
    @PutMapping("/apsinfo")
    public ApsinfoResponseDto saveOrUpdate(@RequestBody ApsinfoRequestDto apsinfoRequestDto){

        HashMap<String,Object> result = new HashMap<>();

        if(apsinfoRequestDto.getTapsinfo().getStatus()!=0){

            commonComponent.logJson("무인정산상태 등록 요청",apsinfoRequestDto);

            result = apsinfoService.save(apsinfoRequestDto);
        }else if(apsinfoRequestDto.getTapsinfo().getStatus()==1 || apsinfoRequestDto.getTapsinfo().getStatus()==2){

            commonComponent.logJson("무인정산상태 수정 요청",apsinfoRequestDto);

            result = apsinfoService.update(apsinfoRequestDto);
        }

        ApsinfoResponseDto response = ApsinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("무인정산상태 등록 또는 수정 응답",response);

        return response;
    }

}
