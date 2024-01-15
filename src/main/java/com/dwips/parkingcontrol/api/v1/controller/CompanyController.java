package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tcompany;
import com.dwips.parkingcontrol.api.v1.dto.CompanyRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CompanyResponseDto;
import com.dwips.parkingcontrol.api.v1.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/company")
    public CompanyResponseDto search(@RequestBody CompanyRequestDto companyRequestDto){

        log.info("회사정보 테이블(등록차량 추가정보) 조회 : ",companyRequestDto.toString());

        HashMap<String,Object> result = companyService.search(companyRequestDto);

        return CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .tcompany((List<Tcompany>) result.get("tcompany"))
                .build();
    }

    @PostMapping("/company")
    public CompanyResponseDto save(@RequestBody CompanyRequestDto companyRequestDto){

        log.info("회사정보 테이블(등록차량 추가정보) 등록 : ",companyRequestDto.toString());

        HashMap<String,Object> result = companyService.save(companyRequestDto);

        return CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .tcompany((List<Tcompany>) result.get("tcompany"))
                .build();
    }

    @PutMapping("/company")
    public CompanyResponseDto update(@RequestBody CompanyRequestDto companyRequestDto){

        log.info("회사정보 테이블(등록차량 추가정보) 수정 : ",companyRequestDto.toString());

        HashMap<String,Object> result = companyService.update(companyRequestDto);

        return CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .tcompany((List<Tcompany>) result.get("tcompany"))
                .build();
    }

    @DeleteMapping("/company")
    public CompanyResponseDto delete(@RequestBody CompanyRequestDto companyRequestDto){

        log.info("회사정보 테이블(등록차량 추가정보) 삭제 : ",companyRequestDto.toString());

        HashMap<String,Object> result = companyService.delete(companyRequestDto);

        return CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }
}
