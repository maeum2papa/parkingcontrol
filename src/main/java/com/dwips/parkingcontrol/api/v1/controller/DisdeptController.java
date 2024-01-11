package com.dwips.parkingcontrol.api.v1.controller;

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

    private final DisdeptService disdeptService;

    @GetMapping("/disdept")
    public DisdeptResponseDto search(@RequestBody DisdeptRequestDto disdeptRequestDto){

        log.info("할인업체 테이블(웹상에서 입주자정보) 조회 : {}",disdeptRequestDto.toString());

        HashMap<String, Object> result = disdeptService.search(disdeptRequestDto);

        return DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisdept((List<Tdisdept>) result.get("tdisdept"))
                .build();
    }

    @PostMapping("/disdept")
    public DisdeptResponseDto save(@RequestBody DisdeptRequestDto disdeptRequestDto){

        log.info("할인업체 테이블(웹상에서 입주자정보) 등록 : {}",disdeptRequestDto.toString());

        HashMap<String, Object> result = disdeptService.save(disdeptRequestDto);

        return DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisdept((List<Tdisdept>) result.get("tdisdept"))
                .build();
    }

    @PutMapping("/disdept")
    public DisdeptResponseDto update(@RequestBody DisdeptRequestDto disdeptRequestDto){

        log.info("할인업체 테이블(웹상에서 입주자정보) 수정 : {}",disdeptRequestDto.toString());

        HashMap<String, Object> result = disdeptService.update(disdeptRequestDto);

        return DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisdept((List<Tdisdept>) result.get("tdisdept"))
                .build();
    }

    @DeleteMapping("/disdept")
    public DisdeptResponseDto delete(@RequestBody DisdeptRequestDto disdeptRequestDto){

        log.info("할인업체 테이블(웹상에서 입주자정보) 수정 : {}",disdeptRequestDto.toString());

        HashMap<String, Object> result = disdeptService.delete(disdeptRequestDto);

        return DisdeptResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }


}
