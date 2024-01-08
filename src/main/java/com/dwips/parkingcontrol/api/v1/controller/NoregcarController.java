package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberExtendRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberExtendResponseDto;
import com.dwips.parkingcontrol.api.v1.service.NoregcarService;
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
public class NoregcarController {

    private final NoregcarService noregcarService;

    @PostMapping("/norecar")
    public NoregcarResponseDto extend(@RequestBody NoregcarRequestDto noregcarRequestDto){

        log.info("미인식차량 등록 : {}",noregcarRequestDto.toString());

        HashMap<String, Object> result = noregcarService.save(noregcarRequestDto);

        return NoregcarResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
