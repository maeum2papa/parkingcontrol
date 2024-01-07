package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberResponseDto;
import com.dwips.parkingcontrol.api.v1.service.PeriodmemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PeriodmemberController {

    private final PeriodmemberService periodmemberService;

    //조회
    @GetMapping("/periodmember")
    public PeriodmemberResponseDto search(@RequestBody PeriodmemberRequestDto periodmemberRequestDto){

        HashMap<String, Object> result = periodmemberService.search(periodmemberRequestDto);

        return PeriodmemberResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodmember((List<Tperiodmember>) result.get("tperiodmember"))
                .build();
    }

    //삭제
    @DeleteMapping("/periodmember")
    public PeriodmemberResponseDto delete(@RequestBody PeriodmemberRequestDto periodmemberRequestDto){

        HashMap<String, Object> result = periodmemberService.delete(periodmemberRequestDto);

        return PeriodmemberResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }
}
