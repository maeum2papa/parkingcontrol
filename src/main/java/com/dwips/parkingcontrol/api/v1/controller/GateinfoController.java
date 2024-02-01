package com.dwips.parkingcontrol.api.v1.controller;

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

    private final TgateinfoService tgateinfoService;

    @GetMapping("/gateinfo")
    public GateinfoResponseDto search(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        log.info("차단기 제어 조회 : {}",gateinfoRequestDto.toString());

        HashMap<String,Object> result = tgateinfoService.search(gateinfoRequestDto);

        return GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

    @PostMapping("/gateinfo")
    public GateinfoResponseDto save(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        log.info("차단기 제어 등록 : {}",gateinfoRequestDto.toString());

        HashMap<String,Object> result = tgateinfoService.save(gateinfoRequestDto);

        return GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

    @PutMapping("/gateinfo")
    public GateinfoResponseDto update(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        log.info("차단기 제어 수정 : {}",gateinfoRequestDto.toString());

        HashMap<String,Object> result = tgateinfoService.update(gateinfoRequestDto);

        return GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

    @DeleteMapping("/gateinfo")
    public GateinfoResponseDto delete(@RequestBody GateinfoRequestDto gateinfoRequestDto){

        log.info("차단기 제어 삭제 : {}",gateinfoRequestDto.toString());

        HashMap<String,Object> result = tgateinfoService.delete(gateinfoRequestDto);

        return GateinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }


}
