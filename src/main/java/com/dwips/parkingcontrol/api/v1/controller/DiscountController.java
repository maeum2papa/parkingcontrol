package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final DiscountService discountService;

    @GetMapping("/discount")
    public DiscountResponseDto search(@ModelAttribute DiscountRequestDto discountRequest){

        commonComponent.logJson("할인요금 테이블 조회 요청",discountRequest);

        HashMap<String,Object> result = discountService.search(discountRequest);

        DiscountResponseDto response = DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();

        commonComponent.logJson("할인요금 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/discount")
    public DiscountResponseDto save(@RequestBody DiscountRequestDto discountRequest){

        commonComponent.logJson("할인요금 테이블 조회 요청",discountRequest);

        HashMap<String,Object> result = discountService.save(discountRequest);

        DiscountResponseDto response = DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();

        commonComponent.logJson("할인요금 테이블 조회 응답",response);

        return response;
    }

    @PutMapping("/discount")
    public DiscountResponseDto update(@RequestBody DiscountRequestDto discountRequest){

        commonComponent.logJson("할인요금 테이블 수정 요청",discountRequest);

        HashMap<String,Object> result = discountService.update(discountRequest);

        DiscountResponseDto response = DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();

        commonComponent.logJson("할인요금 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/discount")
    public DiscountResponseDto delete(@RequestBody DiscountRequestDto discountRequest){

        commonComponent.logJson("할인요금 테이블 삭제 요청",discountRequest);

        HashMap<String,Object> result = discountService.delete(discountRequest);

        DiscountResponseDto response = DiscountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdiscount((List<Tdiscountl>) result.get("tdiscount"))
                .build();

        commonComponent.logJson("할인요금 테이블 삭제 응답",response);

        return response;
    }
}
