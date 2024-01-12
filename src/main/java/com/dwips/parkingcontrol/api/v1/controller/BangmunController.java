package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tbangmun;
import com.dwips.parkingcontrol.api.v1.dto.BangmunRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.BangmunResponseDto;
import com.dwips.parkingcontrol.api.v1.service.BangmunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BangmunController {

    private final BangmunService bangmunService;

    @GetMapping("/bangmun")
    public BangmunResponseDto search(@RequestBody BangmunRequestDto bangmunRequestDto){

        log.info("방문차량 조회 : {}",bangmunRequestDto.toString());

        HashMap<String,Object> result = bangmunService.search(bangmunRequestDto);

        return BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbangmun((List<Tbangmun>) result.get("tbangmun"))
                .build();
    }



    @PostMapping("/bangmun")
    public BangmunResponseDto save(@RequestBody BangmunRequestDto bangmunRequestDto){

        log.info("방문차량 등록 : {}",bangmunRequestDto.toString());

        HashMap<String,Object> result = bangmunService.save(bangmunRequestDto);

        return BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbangmun((List<Tbangmun>) result.get("tbangmun"))
                .build();
    }

    @PutMapping("/bangmun")
    public BangmunResponseDto update(@RequestBody BangmunRequestDto bangmunRequestDto){

        log.info("방문차량 수정 : {}",bangmunRequestDto.toString());

        HashMap<String,Object> result = bangmunService.update(bangmunRequestDto);

        return BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbangmun((List<Tbangmun>) result.get("tbangmun"))
                .build();
    }

    @DeleteMapping("/bangmun")
    public BangmunResponseDto delete(@RequestBody BangmunRequestDto bangmunRequestDto){

        log.info("방문차량 수정 : {}",bangmunRequestDto.toString());

        HashMap<String,Object> result = bangmunService.delete(bangmunRequestDto);

        return BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
