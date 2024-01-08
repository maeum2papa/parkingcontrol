package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tnorecognition;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.*;
import com.dwips.parkingcontrol.api.v1.service.NoregcarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NoregcarController {

    private final NoregcarService noregcarService;

    @PostMapping("/noregcar")
    public NoregcarResponseDto extend(@RequestBody NoregcarRequestDto noregcarRequestDto){

        log.info("미인식차량 등록 : {}",noregcarRequestDto.toString());

        HashMap<String, Object> result = noregcarService.save(noregcarRequestDto);

        return NoregcarResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }


    @GetMapping("/noregcar/search")
    public NoregcarSearchResponseDto search(@RequestBody NoregcarSearchRequestDto noregcarSearchRequestDto){

        log.info("미인식차량 조회 : {}",noregcarSearchRequestDto.toString());

        HashMap<String, Object> result = noregcarService.search(noregcarSearchRequestDto);

        return NoregcarSearchResponseDto.builder()
                .result((Integer) result.get("result"))
                .tnorecognition((List<Tnorecognition>) result.get("tnorecognition"))
                .build();

    }


}
