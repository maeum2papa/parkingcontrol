package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final LogonService logonService;

    @GetMapping("/logon")
    public LogonResponseDto search(@ModelAttribute LogonRequestDto logonRequestDto){

        commonComponent.logJson("로그온 정보 조회 요청",logonRequestDto);

        HashMap<String,Object> result = logonService.search(logonRequestDto);

        LogonResponseDto response = LogonResponseDto.builder()
                .result((Integer) result.get("result"))
                .tlogon((List<Tlogon>) result.get("tlogon"))
                .build();

        commonComponent.logJson("로그온 정보 조회 응답",response);

        return response;
    }

    @PostMapping("/logon")
    public LogonResponseDto save(@RequestBody LogonRequestDto logonRequestDto){

        commonComponent.logJson("로그온 정보 등록 요청",logonRequestDto);

        HashMap<String,Object> result = logonService.save(logonRequestDto);

        LogonResponseDto response = LogonResponseDto.builder()
                .result((Integer) result.get("result"))
                .tlogon((List<Tlogon>) result.get("tlogon"))
                .build();

        commonComponent.logJson("로그온 정보 등록 응답",response);

        return response;
    }

    @DeleteMapping("/logon")
    public LogonResponseDto delete(@RequestBody LogonRequestDto logonRequestDto){

        commonComponent.logJson("로그온 정보 삭제 요청",logonRequestDto);

        HashMap<String,Object> result = logonService.delete(logonRequestDto);

        LogonResponseDto response = LogonResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("로그온 정보 삭제 응답",response);

        return response;
    }


}
