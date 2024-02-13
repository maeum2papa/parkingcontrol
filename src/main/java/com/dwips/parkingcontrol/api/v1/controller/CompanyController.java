package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final CompanyService companyService;

    @GetMapping("/company")
    public CompanyResponseDto search(@ModelAttribute CompanyRequestDto companyRequestDto){

        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 조회 요청",companyRequestDto);

        HashMap<String,Object> result = companyService.search(companyRequestDto);

        CompanyResponseDto response = CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .tcompany((List<Tcompany>) result.get("tcompany"))
                .build();

        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 조회 응답",response);

        return response;
    }

    @PostMapping("/company")
    public CompanyResponseDto save(@RequestBody CompanyRequestDto companyRequestDto){

        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 등록 요청",companyRequestDto);

        HashMap<String,Object> result = companyService.save(companyRequestDto);

        CompanyResponseDto response = CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .tcompany((List<Tcompany>) result.get("tcompany"))
                .build();


        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 등록 응답",response);

        return response;
    }

    @PutMapping("/company")
    public CompanyResponseDto update(@RequestBody CompanyRequestDto companyRequestDto){

        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 수정 요청",companyRequestDto);

        HashMap<String,Object> result = companyService.update(companyRequestDto);

        CompanyResponseDto response = CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .tcompany((List<Tcompany>) result.get("tcompany"))
                .build();

        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 수정 응답",response);

        return response;
    }

    @DeleteMapping("/company")
    public CompanyResponseDto delete(@RequestBody CompanyRequestDto companyRequestDto){

        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 삭제 요청",companyRequestDto);

        HashMap<String,Object> result = companyService.delete(companyRequestDto);

        CompanyResponseDto response = CompanyResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();



        commonComponent.logJson("회사정보 테이블(등록차량 추가정보) 삭제 응답",response);

        return response;
    }
}
