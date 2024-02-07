package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final BangmunService bangmunService;

    @GetMapping("/bangmun")
    public BangmunResponseDto search(@RequestBody BangmunRequestDto bangmunRequestDto){

        commonComponent.logJson("방문차량 조회 요청",bangmunRequestDto);

        HashMap<String,Object> result = bangmunService.search(bangmunRequestDto);

        BangmunResponseDto response = BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbangmun((List<Tbangmun>) result.get("tbangmun"))
                .build();

        commonComponent.logJson("방문차량 조회 응답",response);

        return response;
    }



    @PostMapping("/bangmun")
    public BangmunResponseDto save(@RequestBody BangmunRequestDto bangmunRequestDto){

        commonComponent.logJson("방문차량 등록 요청",bangmunRequestDto);

        HashMap<String,Object> result = bangmunService.save(bangmunRequestDto);

        BangmunResponseDto response = BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbangmun((List<Tbangmun>) result.get("tbangmun"))
                .build();

        commonComponent.logJson("방문차량 등록 응답",response);

        return response;
    }

    @PutMapping("/bangmun")
    public BangmunResponseDto update(@RequestBody BangmunRequestDto bangmunRequestDto){

        commonComponent.logJson("방문차량 수정 요청",bangmunRequestDto);

        HashMap<String,Object> result = bangmunService.update(bangmunRequestDto);

        BangmunResponseDto response = BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbangmun((List<Tbangmun>) result.get("tbangmun"))
                .build();

        commonComponent.logJson("방문차량 수정 응답",response);

        return response;
    }

    @DeleteMapping("/bangmun")
    public BangmunResponseDto delete(@RequestBody BangmunRequestDto bangmunRequestDto){

        commonComponent.logJson("방문차량 삭제 요청",bangmunRequestDto);

        HashMap<String,Object> result = bangmunService.delete(bangmunRequestDto);

        BangmunResponseDto response = BangmunResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("방문차량 삭제 응답",response);

        return response;
    }

}
