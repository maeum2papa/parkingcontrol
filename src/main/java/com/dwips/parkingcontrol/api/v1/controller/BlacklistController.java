package com.dwips.parkingcontrol.api.v1.controller;

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

    private final BlacklistService blacklistService;

    @GetMapping("/blacklist")
    public BlackListResponseDto search(@RequestBody BlackListRequestDto blackListRequestDto){

        log.info("블랙리스트 조회 : {}",blackListRequestDto.getTblacklist());

        HashMap<String, Object> result = blacklistService.search(blackListRequestDto);

        return BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .tblacklist((List<Tblacklist>) result.get("tblacklist"))
                .build();
    }

    @PostMapping("/blacklist")
    public BlackListResponseDto save(@RequestBody BlackListRequestDto blackListRequestDto) {

        log.info("블랙리스트 등록 : {}",blackListRequestDto.getTblacklist());

        HashMap<String, Object> result = blacklistService.save(blackListRequestDto);

        return BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .tblacklist((List<Tblacklist>) result.get("tblacklist"))
                .build();
    }

    @PutMapping("/blacklist")
    public BlackListResponseDto update(@RequestBody BlackListRequestDto blackListRequestDto) {

        log.info("블랙리스트 수정 : {}",blackListRequestDto.getTblacklist());

        HashMap<String, Object> result = blacklistService.update(blackListRequestDto);

        return BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .tblacklist((List<Tblacklist>) result.get("tblacklist"))
                .build();
    }

    @DeleteMapping("/blacklist")
    public BlackListResponseDto delete(@RequestBody BlackListRequestDto blackListRequestDto) {

        log.info("블랙리스트 삭제 : {}",blackListRequestDto.getTblacklist());

        HashMap<String, Object> result = blacklistService.delete(blackListRequestDto);

        return BlackListResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
