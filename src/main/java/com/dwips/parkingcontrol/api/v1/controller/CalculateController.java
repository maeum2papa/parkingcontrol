package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.*;
import com.dwips.parkingcontrol.api.v1.dto.*;
import com.dwips.parkingcontrol.api.v1.service.CalculateSearchService;
import com.dwips.parkingcontrol.api.v1.service.CalculateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CalculateController {

    private final CalculateService calculateService;

    private final CalculateSearchService calculateSearchService;

    @PostMapping("/calculate")
    public CalculateResponseDto calculate(@RequestBody CalculateRequestDto calculateRequestDto){

        log.info("정산 조회 : {}",calculateRequestDto.toString());

        if(!calculateRequestDto.getIOTYPE().equals("C")){
            throw new RuntimeException("정산 정보가 아닙니다.");
        }

        HashMap<String, Object> result = calculateService.calculate(calculateRequestDto);

        return CalculateResponseDto.builder()
                .result((Integer) result.get("result"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .tbcardinfo((List<List<Tbcardinfo>>) result.get("tbcardinfo"))
                .tdiscountinfo((List<List<Tdiscountinfo>>) result.get("tdiscountinfo"))
                .tperiodmember((Tperiodmember) result.get("tperiodmember"))
                .welfare((List<List<Twelfare>>) result.get("welfare"))
                .build();

    }

    @GetMapping("/calculate/search")
    public ResponseEntity<?> calculateSearch(@RequestBody CalculateSearchRequestDto calculateSearchRequestDto){

        log.info("차량 정산내역조회 : {}",calculateSearchRequestDto.toString());

        Object responseResult = null;
        Long qtype = calculateSearchRequestDto.getQtype();

        if(calculateSearchRequestDto.getDatefrom().length() == 10){
            calculateSearchRequestDto.setDatefrom(
                    calculateSearchRequestDto.getDatefrom() + " 00:00:00"
            );
        }

        if(calculateSearchRequestDto.getDateto().length() == 10){
            calculateSearchRequestDto.setDateto(
                    calculateSearchRequestDto.getDateto() + " 23:59:59"
            );
        }

        /*
        0 : tparkinfo,tdiscountinfo,tbcardinfo,twelfare
        1 : tparkinfo,tdiscountinfo,tbcardinfo
        2 : tparkinfo,tdiscountinfo
        3 : 요약정보
        4 : 업체별할인조회 tparkinfo
        5 : 담당자별 현황 tparkinfo
        6 : 일별요약정보
         */
        if(qtype == 0 || qtype == 1 || qtype == 2){
            Map<String, Object> result = calculateSearchService.defaultSearch(calculateSearchRequestDto);

            responseResult = CalculateSearchResponseDto.builder()
                    .result((Integer) result.get("result"))
                    .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                    .tdiscountinfo((Map<Long, List<Tdiscountinfo>>) result.get("tdiscountinfo"))
                    .tbcardinfo((Map<Long, List<Tbcardinfo>>) result.get("tbcardinfo"))
                    .welfare((Map<Long, List<Twelfare>>) result.get("welfare"))
                    .build();

        }else if(qtype == 3){
            Map<String, Object> result = calculateSearchService.summarySearch(calculateSearchRequestDto);

            responseResult = CalculateSearchSummaryResponseDto.builder()
                    .result((Integer) result.get("result"))
                    .totin((Long) result.get("totin"))
                    .totout((Map<String, Long>) result.get("totout"))
                    .totcartype((List<Map<String, Long>>) result.get("totcartype"))
                    .totdevice((List<Map<String, Long>>) result.get("totdevice"))
                    .totdiscode((List<Map<String, Long>>) result.get("totdiscode"))
                    .totparktype((List<Map<String, Long>>) result.get("totparktype"))
                    .totcartype((List<Map<String, Long>>) result.get("totcartype"))
                    .totpaytype((List<Map<String, Long>>) result.get("totpaytype"))
                    .totdiscount((Map<String, Long>) result.get("totdiscount"))
                    .totgrace((Map<String, Long>) result.get("totgrace"))
                    .build();

        }else if(qtype == 4){

            Map<String, Object> result = calculateSearchService.deptcodesSearch(calculateSearchRequestDto);

            responseResult = CalculateSearchDeptcodeResponseDto.builder()
                    .result((Integer) result.get("result"))
                    .tparkinfo((HashMap<Long, List<Tparkinfo>>) result.get("tparkinfo"))
                    .build();

        }else if(qtype == 5){

            Map<String, Object> result = calculateSearchService.midsSearch(calculateSearchRequestDto);
            System.out.println("result.get(\"tparkinfo\") = " + result.get("tparkinfo"));
            responseResult = CalculateSearchMidResponseDto.builder()
                    .result((Integer) result.get("result"))
                    .tparkinfo((HashMap<String, List<Tparkinfo>>) result.get("tparkinfo"))
                    .build();

        }else if(qtype == 6){
            Map<String, Object> result = calculateSearchService.summaryDaysSearch(calculateSearchRequestDto);

            responseResult = CalculateSearchSummaryDaysResponseDto.builder()
                    .result((Integer) result.get("result"))
                    .totin((HashMap<String, Long>) result.get("totin"))
                    .totout((HashMap<String, Map<String, Long>>) result.get("totout"))
                    .totpaytype((HashMap<String, List<Map<String, Long>>>) result.get("totpaytype"))
                    .totdiscount((HashMap<String, Map<String, Long>>) result.get("totdiscount"))
                    .totgrace((HashMap<String, Map<String, Long>>) result.get("totgrace"))
                    .totcartype((HashMap<String, List<Map<String, Long>>>) result.get("totcartype"))
                    .totparktype((HashMap<String, List<Map<String, Long>>>) result.get("totparktype"))
                    .totdiscode((HashMap<String, List<Map<String, Long>>>) result.get("totdiscode"))
                    .totdevice((HashMap<String, List<Map<String, Long>>>) result.get("totdevice"))
                    .build();
        }

        return ResponseEntity.ok(responseResult);
    }

}
