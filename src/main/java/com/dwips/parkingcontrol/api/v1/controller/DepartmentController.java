package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tdepartment;
import com.dwips.parkingcontrol.api.v1.dto.DepartmentRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DepartmentResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DepartmentController {

    private final CommonComponent commonComponent;

    private final DepartmentService departmentService;

    @GetMapping("/department")
    public DepartmentResponseDto search(@ModelAttribute DepartmentRequestDto departmentRequestDto){

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 조회 요청",departmentRequestDto);

        HashMap<String,Object> result  = departmentService.search(departmentRequestDto);

        DepartmentResponseDto response = DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdepartment((List<Tdepartment>) result.get("tdepartment"))
                .build();

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 조회 응답",response);

        return response;
    }

    @PostMapping("/department")
    public DepartmentResponseDto save(@RequestBody DepartmentRequestDto departmentRequestDto){

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 등록 요청",departmentRequestDto);

        HashMap<String,Object> result  = departmentService.save(departmentRequestDto);


        DepartmentResponseDto response = DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdepartment((List<Tdepartment>) result.get("tdepartment"))
                .build();

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 등록 응답",response);

        return response;

    }

    @PutMapping("/department")
    public DepartmentResponseDto update(@RequestBody DepartmentRequestDto departmentRequestDto){

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 수정 요청",departmentRequestDto);

        HashMap<String,Object> result  = departmentService.update(departmentRequestDto);

        DepartmentResponseDto response = DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdepartment((List<Tdepartment>) result.get("tdepartment"))
                .build();

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 수정 응답",response);

        return response;

    }

    @DeleteMapping("/department")
    public DepartmentResponseDto delete(@RequestBody DepartmentRequestDto departmentRequestDto){

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 삭제 요청",departmentRequestDto);

        HashMap<String,Object> result  = departmentService.delete(departmentRequestDto);

        DepartmentResponseDto response = DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("부서정보 테이블(등록차량 추가정보) 수정 응답",response);

        return response;
    }

}
