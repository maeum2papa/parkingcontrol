package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkunpaied;
import com.dwips.parkingcontrol.api.v1.dto.ParkunpaiedRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkunpaiedResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkunpaiedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ParkunpaiedController {

    private final CommonComponent commonComponent;

    private final ParkunpaiedService parkunpaiedService;

    @GetMapping("/parkunpaied")
    public ParkunpaiedResponseDto search(@ModelAttribute ParkunpaiedRequestDto parkunpaiedRequestDto){


        commonComponent.logJson("미납차량정보 조회 요청",parkunpaiedRequestDto);

        HashMap<String,Object> result = parkunpaiedService.search(parkunpaiedRequestDto);

        ParkunpaiedResponseDto response = ParkunpaiedResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkunpaied((List<Tparkunpaied>) result.get("tparkunpaied"))
                .build();

        commonComponent.logJson("미납차량정보 조회 응답",response);

        return response;
    }


    @PostMapping("/parkunpaied")
    public ParkunpaiedResponseDto save(@RequestBody ParkunpaiedRequestDto parkunpaiedRequestDto){

        commonComponent.logJson("미납차량정보 등록 요청",parkunpaiedRequestDto);

        HashMap<String,Object> result = parkunpaiedService.save(parkunpaiedRequestDto);

        ParkunpaiedResponseDto response = ParkunpaiedResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkunpaied((List<Tparkunpaied>) result.get("tparkunpaied"))
                .tparkinfo((Tparkinfo) result.get("tparkinfo"))
                .build();

        commonComponent.logJson("미납차량정보 등록 응답",response);

        return response;
    }

    @DeleteMapping("/parkunpaied")
    public ParkunpaiedResponseDto delete(@RequestBody ParkunpaiedRequestDto parkunpaiedRequestDto){

        commonComponent.logJson("미납차량정보 삭제 요청",parkunpaiedRequestDto);

        HashMap<String,Object> result = parkunpaiedService.delete(parkunpaiedRequestDto);

        ParkunpaiedResponseDto response = ParkunpaiedResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("미납차량정보 삭제 응답",response);

        return response;
    }
}
