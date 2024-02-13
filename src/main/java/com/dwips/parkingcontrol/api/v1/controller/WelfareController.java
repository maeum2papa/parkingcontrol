package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final WelfareService welfareService;

    @GetMapping("/welfare")
    public WelfareResponseDto search(@ModelAttribute WelfareRequestDto welfareRequestDto){


        commonComponent.logJson("사전할인차량 테이블 조회 요청",welfareRequestDto);

        HashMap<String,Object> result = welfareService.search(welfareRequestDto);

        WelfareResponseDto response = WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .twelfare((List<Twelfare>) result.get("twelfare"))
                .build();


        commonComponent.logJson("사전할인차량 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/welfare")
    public WelfareResponseDto save(@RequestBody WelfareRequestDto welfareRequestDto){


        commonComponent.logJson("사전할인차량 테이블 등록 요청",welfareRequestDto);

        HashMap<String,Object> result = welfareService.save(welfareRequestDto);

        WelfareResponseDto response = WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .twelfare((List<Twelfare>) result.get("twelfare"))
                .build();


        commonComponent.logJson("사전할인차량 테이블 등록 응답",response);

        return response;
    }

    @PutMapping("/welfare")
    public WelfareResponseDto update(@RequestBody WelfareRequestDto welfareRequestDto){


        commonComponent.logJson("사전할인차량 테이블 수정 요청",welfareRequestDto);

        HashMap<String,Object> result = welfareService.update(welfareRequestDto);

        WelfareResponseDto response = WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .twelfare((List<Twelfare>) result.get("twelfare"))
                .build();

        commonComponent.logJson("사전할인차량 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/welfare")
    public WelfareResponseDto delete(@RequestBody WelfareRequestDto welfareRequestDto){


        commonComponent.logJson("사전할인차량 테이블 삭제 요청",welfareRequestDto);

        HashMap<String,Object> result = welfareService.delete(welfareRequestDto);

        WelfareResponseDto response = WelfareResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("사전할인차량 테이블 삭제 응답",response);

        return response;
    }

}
