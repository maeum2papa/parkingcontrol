package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.*;
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

    private final CommonComponent commonComponent;

    private final PeriodmemberService periodmemberService;

    //조회
    @GetMapping("/periodmember")
    public PeriodmemberResponseDto search(@RequestBody PeriodmemberRequestDto periodmemberRequestDto){


        commonComponent.logJson("등록차량조회 요청",periodmemberRequestDto);

        HashMap<String, Object> result = periodmemberService.search(periodmemberRequestDto);

        PeriodmemberResponseDto response = PeriodmemberResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodmember((List<Tperiodmember>) result.get("tperiodmember"))
                .build();

        commonComponent.logJson("등록차량조회 응답",response);

        return response;
    }

    //삭제
    @DeleteMapping("/periodmember")
    public PeriodmemberResponseDto delete(@RequestBody PeriodmemberRequestDto periodmemberRequestDto){


        commonComponent.logJson("등록차량삭제 요청",periodmemberRequestDto);

        HashMap<String, Object> result = periodmemberService.delete(periodmemberRequestDto);

        PeriodmemberResponseDto response = PeriodmemberResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("등록차량삭제 응답",response);

        return response;
    }

    //연장
    @PostMapping("/periodmember/extend")
    public PeriodmemberExtendResponseDto extend(@RequestBody PeriodmemberExtendRequestDto periodmemberExtendRequestDto){


        commonComponent.logJson("등록차량연장 요청",periodmemberExtendRequestDto);

        HashMap<String, Object> result = periodmemberService.extend(periodmemberExtendRequestDto);

        PeriodmemberExtendResponseDto response = PeriodmemberExtendResponseDto.builder()
                .result((Integer) result.get("result"))
                .tperiodmember((Tperiodmember) result.get("tperiodmember"))
                .build();


        commonComponent.logJson("등록차량연장 응답",response);

        return response;
    }

}
