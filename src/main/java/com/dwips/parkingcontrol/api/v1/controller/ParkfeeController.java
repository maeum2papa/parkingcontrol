package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tparkfee;
import com.dwips.parkingcontrol.api.v1.dto.ParkfeeRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkfeeResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkfeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ParkfeeController {

    private final ParkfeeService parkfeeService;

    @GetMapping("/parkfee")
    public ParkfeeResponseDto search(@RequestBody ParkfeeRequestDto parkfeeRequestDto){

        log.info("주차장 요금 테이블 조회 : {}",parkfeeRequestDto.toString());

        HashMap<String,Object> result = parkfeeService.search(parkfeeRequestDto);

        return ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .parkfee((List<Tparkfee>) result.get("parkfee"))
                .build();
    }

    @PostMapping("/parkfee")
    public ParkfeeResponseDto save(@RequestBody ParkfeeRequestDto parkfeeRequestDto){

        log.info("주차장 요금 테이블 등록 : {}",parkfeeRequestDto.toString());

        HashMap<String,Object> result = parkfeeService.save(parkfeeRequestDto);

        return ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .parkfee((List<Tparkfee>) result.get("parkfee"))
                .build();
    }

    @PutMapping("/parkfee")
    public ParkfeeResponseDto update(@RequestBody ParkfeeRequestDto parkfeeRequestDto){

        log.info("주차장 요금 테이블 수정 : {}",parkfeeRequestDto.toString());

        HashMap<String,Object> result = parkfeeService.update(parkfeeRequestDto);

        return ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .parkfee((List<Tparkfee>) result.get("parkfee"))
                .build();
    }

    @DeleteMapping("/parkfee")
    public ParkfeeResponseDto delete(@RequestBody ParkfeeRequestDto parkfeeRequestDto){

        log.info("주차장 요금 테이블 삭제 : {}",parkfeeRequestDto.toString());

        HashMap<String,Object> result = parkfeeService.delete(parkfeeRequestDto);

        return ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
