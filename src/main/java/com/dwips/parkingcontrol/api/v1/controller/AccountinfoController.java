package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Taccountinfo;
import com.dwips.parkingcontrol.api.v1.dto.AccountinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.AccountinfoRquestDto;
import com.dwips.parkingcontrol.api.v1.service.AccountinfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Tag(name = "원격할인 카운트", description = "")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AccountinfoController {

    private final AccountinfoService accountinfoService;

    @Operation(summary = "원격할인 카운트 조회", description = "")
    @GetMapping("/accountinfo")
    public AccountinfoResponseDto search(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 조회 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.search(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();
    }

    @Operation(summary = "원격할인 카운트 등록", description = "∴ id 별로 여러개의 diskey 가 있음 id+diskey 로 이중등록 되면 안되고 업데이트 해야 함")
    @PostMapping("/accountinfo")
    public AccountinfoResponseDto save(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 등록 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.save(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();
    }

    @Operation(summary = "원격할인 카운트 수정", description = "")
    @PutMapping("/accountinfo")
    public AccountinfoResponseDto update(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 수정 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.update(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();
    }

    @Operation(summary = "원격할인 카운트 삭제", description = "∴xindex 가 있을 경우 xindex 로 삭제 id 가 있을 경우 해당 id 모두 삭제")
    @DeleteMapping("/accountinfo")
    public AccountinfoResponseDto delete(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        log.info("원격할인 카운트 삭제 : {}",accountinfoRquestDto.toString());

        HashMap<String,Object> result = accountinfoService.delete(accountinfoRquestDto);

        return AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
