package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.dto.BcardinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.BcardinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutResponseDto;
import com.dwips.parkingcontrol.api.v1.service.BcardinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BcardinfoController {

    private final BcardinfoService bcardinfoService;

    @GetMapping("/bcardinfo")
    public BcardinfoResponseDto search(@RequestBody BcardinfoRequestDto bcardinfoRequestDto){

        log.info("신용카드 매출 내역 조회 : {}",bcardinfoRequestDto.toString());

        HashMap<String,Object> result = bcardinfoService.search(bcardinfoRequestDto);

        return BcardinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbcardinfo((List<Tbcardinfo>) result.get("bcardinfo"))
                .build();
    }

}
