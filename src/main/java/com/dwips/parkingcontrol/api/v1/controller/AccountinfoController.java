package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Taccountinfo;
import com.dwips.parkingcontrol.api.v1.dto.AccountinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.AccountinfoRquestDto;
import com.dwips.parkingcontrol.api.v1.service.AccountinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AccountinfoController {

    private final AccountinfoService accountinfoService;

    @GetMapping("/accountinfo")
    public AccountinfoResponseDto search(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 조회 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.search(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();
    }

    @PostMapping("/accountinfo")
    public AccountinfoResponseDto save(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 등록 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.save(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();
    }

    @PutMapping("/accountinfo")
    public AccountinfoResponseDto update(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 수정 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.update(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();
    }

    @DeleteMapping("/accountinfo")
    public AccountinfoResponseDto delete(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 삭제 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.delete(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
