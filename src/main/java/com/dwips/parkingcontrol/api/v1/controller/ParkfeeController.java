package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final ParkfeeService parkfeeService;

    @GetMapping("/parkfee")
    public ParkfeeResponseDto search(@ModelAttribute ParkfeeRequestDto parkfeeRequestDto){


        commonComponent.logJson("주차장 요금 테이블 조회 요청",parkfeeRequestDto);

        HashMap<String,Object> result = parkfeeService.search(parkfeeRequestDto);

        ParkfeeResponseDto response = ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .parkfee((List<Tparkfee>) result.get("parkfee"))
                .build();

        commonComponent.logJson("주차장 요금 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/parkfee")
    public ParkfeeResponseDto save(@RequestBody ParkfeeRequestDto parkfeeRequestDto){

        commonComponent.logJson("주차장 요금 테이블 등록 요청",parkfeeRequestDto);

        HashMap<String,Object> result = parkfeeService.save(parkfeeRequestDto);

        ParkfeeResponseDto response = ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .parkfee((List<Tparkfee>) result.get("parkfee"))
                .build();

        commonComponent.logJson("주차장 요금 테이블 등록 응답",response);

        return response;
    }

    @PutMapping("/parkfee")
    public ParkfeeResponseDto update(@RequestBody ParkfeeRequestDto parkfeeRequestDto){

        commonComponent.logJson("주차장 요금 테이블 수정 요청",parkfeeRequestDto);

        HashMap<String,Object> result = parkfeeService.update(parkfeeRequestDto);

        ParkfeeResponseDto response = ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .parkfee((List<Tparkfee>) result.get("parkfee"))
                .build();

        commonComponent.logJson("주차장 요금 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/parkfee")
    public ParkfeeResponseDto delete(@RequestBody ParkfeeRequestDto parkfeeRequestDto){


        commonComponent.logJson("주차장 요금 테이블 삭제 요청",parkfeeRequestDto);

        HashMap<String,Object> result = parkfeeService.delete(parkfeeRequestDto);

        ParkfeeResponseDto response = ParkfeeResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("주차장 요금 테이블 삭제 응답",response);

        return response;
    }

}
