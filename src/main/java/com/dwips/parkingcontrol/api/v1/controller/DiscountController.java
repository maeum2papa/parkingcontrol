package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountl;
import com.dwips.parkingcontrol.api.v1.dto.DiscountRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DiscountResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DiscountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping("/discount")
    public DiscountResponseDto search(@RequestBody DiscountRequestDto discountRequest){

        log.info("할인요금 테이블 조회 : {}",discountRequest.toString());

        HashMap<String,Object> result = discountService.search(discountRequest);

        return DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();
    }

    @PostMapping("/discount")
    public DiscountResponseDto save(@RequestBody DiscountRequestDto discountRequest){

        log.info("할인요금 테이블 조회 : {}",discountRequest.toString());

        HashMap<String,Object> result = discountService.save(discountRequest);

        return DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();
    }

    @PutMapping("/discount")
    public DiscountResponseDto update(@RequestBody DiscountRequestDto discountRequest){

        log.info("할인요금 테이블 조회 : {}",discountRequest.toString());

        HashMap<String,Object> result = discountService.update(discountRequest);

        return DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();
    }

    @DeleteMapping("/discount")
    public DiscountResponseDto delete(@RequestBody DiscountRequestDto discountRequest){

        log.info("할인요금 테이블 조회 : {}",discountRequest.toString());

        HashMap<String,Object> result = discountService.delete(discountRequest);

        return DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();
    }
}
