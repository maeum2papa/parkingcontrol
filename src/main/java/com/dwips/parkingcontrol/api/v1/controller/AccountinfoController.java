package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final AccountinfoService accountinfoService;

    @Operation(summary = "원격할인 카운트 조회", description = "")
    @GetMapping("/accountinfo")
    public AccountinfoResponseDto search(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        commonComponent.logJson("원격할인 카운트 조회 요청",accountinfoRquestDto);

        HashMap<String,Object> result = accountinfoService.search(accountinfoRquestDto);

        AccountinfoResponseDto response = AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();

        commonComponent.logJson("원격할인 카운트 조회 응답",response);

        return response;
    }

    @Operation(summary = "원격할인 카운트 등록", description = "∴ id 별로 여러개의 diskey 가 있음 id+diskey 로 이중등록 되면 안되고 업데이트 해야 함")
    @PostMapping("/accountinfo")
    public AccountinfoResponseDto save(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        commonComponent.logJson("원격할인 카운트 등록 요청",accountinfoRquestDto);

        HashMap<String,Object> result = accountinfoService.save(accountinfoRquestDto);

        AccountinfoResponseDto response = AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();

        commonComponent.logJson("원격할인 카운트 등록 응답",response);

        return response;
    }

    @Operation(summary = "원격할인 카운트 수정", description = "")
    @PutMapping("/accountinfo")
    public AccountinfoResponseDto update(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        commonComponent.logJson("원격할인 카운트 수정 요청",accountinfoRquestDto);

        HashMap<String,Object> result = accountinfoService.update(accountinfoRquestDto);

        AccountinfoResponseDto response = AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .taccountinfo((List<Taccountinfo>) result.get("taccountinfo"))
                .build();

        commonComponent.logJson("원격할인 카운트 수정 응답",response);

        return response;
    }

    @Operation(summary = "원격할인 카운트 삭제", description = "∴xindex 가 있을 경우 xindex 로 삭제 id 가 있을 경우 해당 id 모두 삭제")
    @DeleteMapping("/accountinfo")
    public AccountinfoResponseDto delete(@RequestBody AccountinfoRquestDto accountinfoRquestDto){

        commonComponent.logJson("원격할인 카운트 삭제 요청",accountinfoRquestDto);

        HashMap<String,Object> result = accountinfoService.delete(accountinfoRquestDto);

        AccountinfoResponseDto response = AccountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("원격할인 카운트 삭제 응답",response);

        return response;
    }

}
