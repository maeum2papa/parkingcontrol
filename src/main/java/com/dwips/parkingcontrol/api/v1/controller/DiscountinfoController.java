package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.dto.DiscountinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DiscountinfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DiscountinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DiscountinfoController {

    private final CommonComponent commonComponent;

    private final DiscountinfoService discountinfoService;

    @GetMapping("/discountinfo")
    public DiscountinfoResponseDto search(@ModelAttribute DiscountinfoRequestDto discountinfoRequestDto){

        commonComponent.logJson("할인내역 조회 요청",discountinfoRequestDto);

        HashMap<String,Object> result = discountinfoService.search(discountinfoRequestDto);

        DiscountinfoResponseDto response = DiscountinfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscountinfo((List<Tdiscountinfo>) result.get("tdiscountinfo"))
                .build();

        commonComponent.logJson("할인내역 조회 응답",response);


        return response;
    }
}
