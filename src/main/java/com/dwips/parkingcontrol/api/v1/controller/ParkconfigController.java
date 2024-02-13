package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final ParkconfigService parkconfigService;

    @GetMapping("/parkconfig")
    public ParkconfigResponseDto search(@ModelAttribute ParkconfigRequestDto parkconfigRequestDto){

        commonComponent.logJson("주차장운영 변수 테이블 조회 요청",parkconfigRequestDto);

        HashMap<String, Object> result  = parkconfigService.search(parkconfigRequestDto);

        ParkconfigResponseDto response = ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();

        commonComponent.logJson("주차장운영 변수 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/parkconfig")
    public ParkconfigResponseDto save(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        commonComponent.logJson("주차장운영 변수 테이블 등록 요청",parkconfigRequestDto);

        HashMap<String, Object> result  = parkconfigService.save(parkconfigRequestDto);

        ParkconfigResponseDto response = ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();

        commonComponent.logJson("주차장운영 변수 테이블 등록 응답",response);

        return response;
    }

    @PutMapping("/parkconfig")
    public ParkconfigResponseDto update(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        commonComponent.logJson("주차장운영 변수 테이블 수정 요청",parkconfigRequestDto);

        HashMap<String, Object> result  = parkconfigService.update(parkconfigRequestDto);

        ParkconfigResponseDto response = ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();

        commonComponent.logJson("주차장운영 변수 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/parkconfig")

    public ParkconfigResponseDto delete(@RequestBody ParkconfigRequestDto parkconfigRequestDto){

        commonComponent.logJson("주차장운영 변수 테이블 삭제 요청",parkconfigRequestDto);

        HashMap<String, Object> result  = parkconfigService.delete(parkconfigRequestDto);

        ParkconfigResponseDto response = ParkconfigResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkconfig((List<Tparkconfig>) result.get("tparkconfig"))
                .build();

        commonComponent.logJson("주차장운영 변수 테이블 삭제 응답",response);

        return response;
    }
}
