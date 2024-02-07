package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tgateinfo;
import com.dwips.parkingcontrol.api.v1.dto.GateinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.GateinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.TgateinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class GateinfoController {

    private final CommonComponent commonComponent;

    private final TgateinfoService tgateinfoService;

    @GetMapping("/gateinfo")
    public GateinfoResponseDto search(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        commonComponent.logJson("차단기 제어 조회 요청",gateinfoRequestDto);

        HashMap<String,Object> result = tgateinfoService.search(gateinfoRequestDto);

        GateinfoResponseDto response = GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("차단기 제어 조회 응답",response);

        return response;
    }

    @PostMapping("/gateinfo")
    public GateinfoResponseDto save(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        commonComponent.logJson("차단기 제어 등록 요청",gateinfoRequestDto);

        HashMap<String,Object> result = tgateinfoService.save(gateinfoRequestDto);

        GateinfoResponseDto response = GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("차단기 제어 등록 응답",response);

        return response;
    }

    @PutMapping("/gateinfo")
    public GateinfoResponseDto update(@RequestBody GateinfoRequestDto gateinfoRequestDto){


        commonComponent.logJson("차단기 제어 수정 요청",gateinfoRequestDto);

        HashMap<String,Object> result = tgateinfoService.update(gateinfoRequestDto);

        GateinfoResponseDto response = GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("차단기 제어 수정 응답",response);

        return response;
    }

    @DeleteMapping("/gateinfo")
    public GateinfoResponseDto delete(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        commonComponent.logJson("차단기 제어 삭제 요청",gateinfoRequestDto);

        HashMap<String,Object> result = tgateinfoService.delete(gateinfoRequestDto);

        GateinfoResponseDto response = GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("차단기 제어 삭제 응답",response);

        return response;
    }


}
