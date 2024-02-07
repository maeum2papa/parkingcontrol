package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tblacklist;
import com.dwips.parkingcontrol.api.v1.dto.BlackListRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.BlackListResponseDto;
import com.dwips.parkingcontrol.api.v1.service.BlacklistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BlacklistController {

    private final CommonComponent commonComponent;

    private final BlacklistService blacklistService;

    @GetMapping("/blacklist")
    public BlackListResponseDto search(@RequestBody BlackListRequestDto blackListRequestDto){

        commonComponent.logJson("블랙리스트 조회 요청",blackListRequestDto);

        HashMap<String, Object> result = blacklistService.search(blackListRequestDto);

        BlackListResponseDto response = BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .tblacklist((List<Tblacklist>) result.get("tblacklist"))
                .build();

        commonComponent.logJson("블랙리스트 조회 응답",response);

        return response;
    }

    @PostMapping("/blacklist")
    public BlackListResponseDto save(@RequestBody BlackListRequestDto blackListRequestDto) {

        commonComponent.logJson("블랙리스트 등록 요청",blackListRequestDto);

        HashMap<String, Object> result = blacklistService.save(blackListRequestDto);

        BlackListResponseDto response = BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .tblacklist((List<Tblacklist>) result.get("tblacklist"))
                .build();

        commonComponent.logJson("블랙리스트 등록 응답",response);

        return response;
    }

    @PutMapping("/blacklist")
    public BlackListResponseDto update(@RequestBody BlackListRequestDto blackListRequestDto) {


        commonComponent.logJson("블랙리스트 수정 요청",blackListRequestDto);

        HashMap<String, Object> result = blacklistService.update(blackListRequestDto);

        BlackListResponseDto response = BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .tblacklist((List<Tblacklist>) result.get("tblacklist"))
                .build();

        commonComponent.logJson("블랙리스트 수정 응답",response);

        return response;
    }

    @DeleteMapping("/blacklist")
    public BlackListResponseDto delete(@RequestBody BlackListRequestDto blackListRequestDto) {


        commonComponent.logJson("블랙리스트 삭제 요청",blackListRequestDto);

        HashMap<String, Object> result = blacklistService.delete(blackListRequestDto);

        BlackListResponseDto response = BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("블랙리스트 삭제 응답",response);

        return response;
    }

}
