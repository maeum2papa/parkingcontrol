package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tlogon;
import com.dwips.parkingcontrol.api.v1.dto.LogonRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.LogonResponseDto;
import com.dwips.parkingcontrol.api.v1.service.LogonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class LogonController {

    private final LogonService logonService;

    @GetMapping("/logon")
    public LogonResponseDto search(@RequestBody LogonRequestDto logonRequestDto){

        log.info("로그온 정보 조회 : {}",logonRequestDto.toString());

        HashMap<String,Object> result = logonService.search(logonRequestDto);

        return LogonResponseDto.builder()
                .result((Integer) result.get("result"))
                .tlogon((List<Tlogon>) result.get("tlogon"))
                .build();
    }

    @PostMapping("/logon")
    public LogonResponseDto save(@RequestBody LogonRequestDto logonRequestDto){

        log.info("로그온 정보 등록 : {}",logonRequestDto.toString());

        HashMap<String,Object> result = logonService.save(logonRequestDto);

        return LogonResponseDto.builder()
                .result((Integer) result.get("result"))
                .tlogon((List<Tlogon>) result.get("tlogon"))
                .build();
    }

    @DeleteMapping("/logon")
    public LogonResponseDto delete(@RequestBody LogonRequestDto logonRequestDto){

        log.info("로그온 정보 삭제 : {}",logonRequestDto.toString());

        HashMap<String,Object> result = logonService.delete(logonRequestDto);

        return LogonResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }


}
