package com.dwips.parkingcontrol.api.v1.controller;

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

    private final HolidayService holidayService;

    @GetMapping("/holiday")
    public HolidayResponseDto search(@RequestBody HolidayRequestDto holidayRequestDto){

        log.info(" 휴일 테이블 조회 : {}",holidayRequestDto.toString());

        HashMap<String,Object> result = holidayService.search(holidayRequestDto);

        return HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .tholiday((List<Tholiday>) result.get("tholiday"))
                .build();
    }

    @PostMapping("/holiday")
    public HolidayResponseDto save(@RequestBody HolidayRequestDto holidayRequestDto){

        log.info(" 휴일 테이블 등록 : {}",holidayRequestDto.toString());

        HashMap<String,Object> result = holidayService.save(holidayRequestDto);

        return HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .tholiday((List<Tholiday>) result.get("tholiday"))
                .build();
    }

    @PutMapping("/holiday")
    public HolidayResponseDto update(@RequestBody HolidayRequestDto holidayRequestDto){

        log.info(" 휴일 테이블 수정 : {}",holidayRequestDto.toString());

        HashMap<String,Object> result = holidayService.update(holidayRequestDto);

        return HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .tholiday((List<Tholiday>) result.get("tholiday"))
                .build();
    }

    @DeleteMapping("/holiday")
    public HolidayResponseDto delete(@RequestBody HolidayRequestDto holidayRequestDto){

        log.info(" 휴일 테이블 삭제 : {}",holidayRequestDto.toString());

        HashMap<String,Object> result = holidayService.delete(holidayRequestDto);

        return HolidayResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
