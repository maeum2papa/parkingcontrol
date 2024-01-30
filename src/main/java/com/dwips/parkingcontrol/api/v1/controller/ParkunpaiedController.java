package com.dwips.parkingcontrol.api.v1.controller;

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

    private final ParkunpaiedService parkunpaiedService;

    @GetMapping("/parkunpaied")
    public ParkunpaiedResponseDto search(@RequestBody ParkunpaiedRequestDto parkunpaiedRequestDto){

        log.info("미납차량정보 조회 : {}",parkunpaiedRequestDto.toString());

        HashMap<String,Object> result = parkunpaiedService.search(parkunpaiedRequestDto);

        return ParkunpaiedResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkunpaied((List<Tparkunpaied>) result.get("tparkunpaied"))
                .build();
    }


    @PostMapping("/parkunpaied")
    public ParkunpaiedResponseDto save(@RequestBody ParkunpaiedRequestDto parkunpaiedRequestDto){

        log.info("미납차량정보 등록 : {}",parkunpaiedRequestDto.toString());

        HashMap<String,Object> result = parkunpaiedService.save(parkunpaiedRequestDto);

        return ParkunpaiedResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkunpaied((List<Tparkunpaied>) result.get("tparkunpaied"))
                .tparkinfo((Tparkinfo) result.get("tparkinfo"))
                .build();
    }

    @DeleteMapping("/parkunpaied")
    public ParkunpaiedResponseDto delete(@RequestBody ParkunpaiedRequestDto parkunpaiedRequestDto){

        log.info("미납차량정보 삭제 : {}",parkunpaiedRequestDto.toString());

        HashMap<String,Object> result = parkunpaiedService.delete(parkunpaiedRequestDto);

        return ParkunpaiedResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }
}
