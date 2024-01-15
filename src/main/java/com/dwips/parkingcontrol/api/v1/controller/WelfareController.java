package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import com.dwips.parkingcontrol.api.v1.dto.WelfareRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.WelfareResponseDto;
import com.dwips.parkingcontrol.api.v1.service.WelfareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WelfareController {

    private final WelfareService welfareService;

    @GetMapping("/welfare")
    public WelfareResponseDto search(@RequestBody WelfareRequestDto welfareRequestDto){

        log.info("사전할인차량 테이블 조회 : {}",welfareRequestDto.toString());

        HashMap<String,Object> result = welfareService.search(welfareRequestDto);

        return WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .twelfare((List<Twelfare>) result.get("twelfare"))
                .build();
    }

    @PostMapping("/welfare")
    public WelfareResponseDto save(@RequestBody WelfareRequestDto welfareRequestDto){

        log.info("사전할인차량 테이블 등록 : {}",welfareRequestDto.toString());

        HashMap<String,Object> result = welfareService.save(welfareRequestDto);

        return WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .twelfare((List<Twelfare>) result.get("twelfare"))
                .build();
    }

    @PutMapping("/welfare")
    public WelfareResponseDto update(@RequestBody WelfareRequestDto welfareRequestDto){

        log.info("사전할인차량 테이블 수정 : {}",welfareRequestDto.toString());

        HashMap<String,Object> result = welfareService.update(welfareRequestDto);

        return WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .twelfare((List<Twelfare>) result.get("twelfare"))
                .build();
    }

    @DeleteMapping("/welfare")
    public WelfareResponseDto delete(@RequestBody WelfareRequestDto welfareRequestDto){

        log.info("사전할인차량 테이블 삭제 : {}",welfareRequestDto.toString());

        HashMap<String,Object> result = welfareService.delete(welfareRequestDto);

        return WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
