package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tparkconfig;
import com.dwips.parkingcontrol.api.v1.dto.ParkconfigRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkconfigResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkconfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ParkconfigController {

    private final ParkconfigService parkconfigService;

    @GetMapping("/parkconfig")
    public ParkconfigResponseDto search(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        log.info("주차장운영 변수 테이블 조회 : {}",parkconfigRequestDto.toString());

        HashMap<String, Object> result  = parkconfigService.search(parkconfigRequestDto);

        return ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();
    }

    @PostMapping("/parkconfig")
    public ParkconfigResponseDto save(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        log.info("주차장운영 변수 테이블 등록 : {}",parkconfigRequestDto.toString());

        HashMap<String, Object> result  = parkconfigService.save(parkconfigRequestDto);

        return ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();
    }

    @PutMapping("/parkconfig")
    public ParkconfigResponseDto update(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        log.info("주차장운영 변수 테이블 수정 : {}",parkconfigRequestDto.toString());

        HashMap<String, Object> result  = parkconfigService.update(parkconfigRequestDto);

        return ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();
    }

    @DeleteMapping("/parkconfig")

    public ParkconfigResponseDto delete(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        log.info("주차장운영 변수 테이블 삭제 : {}",parkconfigRequestDto.toString());

        HashMap<String, Object> result  = parkconfigService.delete(parkconfigRequestDto);

        return ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();
    }
}
