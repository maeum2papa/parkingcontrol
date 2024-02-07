package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tholiday;
import com.dwips.parkingcontrol.api.v1.dto.HolidayRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.HolidayResponseDto;
import com.dwips.parkingcontrol.api.v1.service.HolidayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class HolidayController {

    private final CommonComponent commonComponent;

    private final HolidayService holidayService;

    @GetMapping("/holiday")
    public HolidayResponseDto search(@RequestBody HolidayRequestDto holidayRequestDto){

        commonComponent.logJson("휴일 테이블 조회 요청",holidayRequestDto);

        HashMap<String,Object> result = holidayService.search(holidayRequestDto);

        HolidayResponseDto response = HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .tholiday((List<Tholiday>) result.get("tholiday"))
                .build();

        commonComponent.logJson("휴일 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/holiday")
    public HolidayResponseDto save(@RequestBody HolidayRequestDto holidayRequestDto){

        commonComponent.logJson("휴일 테이블 등록 요청",holidayRequestDto);

        HashMap<String,Object> result = holidayService.save(holidayRequestDto);

        HolidayResponseDto response = HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .tholiday((List<Tholiday>) result.get("tholiday"))
                .build();

        commonComponent.logJson("휴일 테이블 등록 응답",response);

        return response;
    }

    @PutMapping("/holiday")
    public HolidayResponseDto update(@RequestBody HolidayRequestDto holidayRequestDto){

        commonComponent.logJson("휴일 테이블 수정 요청",holidayRequestDto);

        HashMap<String,Object> result = holidayService.update(holidayRequestDto);

        HolidayResponseDto response = HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .tholiday((List<Tholiday>) result.get("tholiday"))
                .build();

        commonComponent.logJson("휴일 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/holiday")
    public HolidayResponseDto delete(@RequestBody HolidayRequestDto holidayRequestDto){


        commonComponent.logJson("휴일 테이블 삭제 요청",holidayRequestDto);

        HashMap<String,Object> result = holidayService.delete(holidayRequestDto);

        HolidayResponseDto response = HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("휴일 테이블 삭제 응답",response);

        return response;
    }

}
