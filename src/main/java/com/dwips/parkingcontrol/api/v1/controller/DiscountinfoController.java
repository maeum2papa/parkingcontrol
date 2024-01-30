package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.dto.DiscountinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DiscountinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DiscountinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DiscountinfoController {

    private final DiscountinfoService discountinfoService;

    @GetMapping("/discountinfo")
    public DiscountinfoResponseDto search(@RequestBody DiscountinfoRequestDto discountinfoRequestDto){

        log.info("할인내역 조회 : {}",discountinfoRequestDto.toString());

        HashMap<String,Object> result = discountinfoService.search(discountinfoRequestDto);

        return DiscountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscountinfo((List<Tdiscountinfo>) result.get("tdiscountinfo"))
                .build();
    }
}
