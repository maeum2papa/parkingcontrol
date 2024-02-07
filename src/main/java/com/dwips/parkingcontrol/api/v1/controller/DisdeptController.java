package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tdisdept;
import com.dwips.parkingcontrol.api.v1.dto.DisdeptRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DisdeptResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DisdeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DisdeptController {

    private final CommonComponent commonComponent;

    private final DisdeptService disdeptService;

    @GetMapping("/disdept")
    public DisdeptResponseDto search(@RequestBody DisdeptRequestDto disdeptRequestDto){


        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 조회 요청",disdeptRequestDto);

        HashMap<String, Object> result = disdeptService.search(disdeptRequestDto);

        DisdeptResponseDto response = DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisdept((List<Tdisdept>) result.get("tdisdept"))
                .build();

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 조회 응답",response);

        return response;
    }

    @PostMapping("/disdept")
    public DisdeptResponseDto save(@RequestBody DisdeptRequestDto disdeptRequestDto){

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 등록 요청",disdeptRequestDto);

        HashMap<String, Object> result = disdeptService.save(disdeptRequestDto);

        DisdeptResponseDto response = DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisdept((List<Tdisdept>) result.get("tdisdept"))
                .build();

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 등록 응답",response);

        return response;
    }

    @PutMapping("/disdept")
    public DisdeptResponseDto update(@RequestBody DisdeptRequestDto disdeptRequestDto){

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 수정 요청",disdeptRequestDto);

        HashMap<String, Object> result = disdeptService.update(disdeptRequestDto);

        DisdeptResponseDto response = DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisdept((List<Tdisdept>) result.get("tdisdept"))
                .build();

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 수정 응답",response);

        return response;
    }

    @DeleteMapping("/disdept")
    public DisdeptResponseDto delete(@RequestBody DisdeptRequestDto disdeptRequestDto){

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 삭제 요청",disdeptRequestDto);

        HashMap<String, Object> result = disdeptService.delete(disdeptRequestDto);

        DisdeptResponseDto response = DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("할인업체 테이블(웹상에서 입주자정보) 삭제 응답",response);

        return response;
    }


}
