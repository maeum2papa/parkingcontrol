package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final NoregcarService noregcarService;

    @PostMapping("/noregcar")
    public NoregcarResponseDto extend(@RequestBody NoregcarRequestDto noregcarRequestDto){

        commonComponent.logJson("미인식차량 등록 요청",noregcarRequestDto);

        HashMap<String, Object> result = noregcarService.save(noregcarRequestDto);

        NoregcarResponseDto response = NoregcarResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("미인식차량 등록 응답",response);

        return response;
    }


    @GetMapping("/noregcar/search")
    public NoregcarSearchResponseDto search(@RequestBody NoregcarSearchRequestDto noregcarSearchRequestDto){


        commonComponent.logJson("미인식차량 조회 요청",noregcarSearchRequestDto);

        HashMap<String, Object> result = noregcarService.search(noregcarSearchRequestDto);

        NoregcarSearchResponseDto response = NoregcarSearchResponseDto.builder()
                .result((Integer) result.get("result"))
                .tnorecognition((List<Tnorecognition>) result.get("tnorecognition"))
                .build();

        commonComponent.logJson("미인식차량 조회 응답",response);

        return response;

    }


}
