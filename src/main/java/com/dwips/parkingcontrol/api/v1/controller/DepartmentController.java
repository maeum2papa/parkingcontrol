package com.dwips.parkingcontrol.api.v1.controller;

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

    private final DepartmentService departmentService;

    @GetMapping("/department")
    public DepartmentResponseDto search(@RequestBody DepartmentRequestDto departmentRequestDto){

        log.info("부서정보 테이블(등록차량 추가정보) 조회 : {}",departmentRequestDto.toString());

        HashMap<String,Object> result  = departmentService.search(departmentRequestDto);

        return DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdepartment((List<Tdepartment>) result.get("tdepartment"))
                .build();
    }

    @PostMapping("/department")
    public DepartmentResponseDto save(@RequestBody DepartmentRequestDto departmentRequestDto){

        log.info("부서정보 테이블(등록차량 추가정보) 등록 : {}",departmentRequestDto.toString());

        HashMap<String,Object> result  = departmentService.save(departmentRequestDto);

        return DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdepartment((List<Tdepartment>) result.get("tdepartment"))
                .build();
    }

    @PutMapping("/department")
    public DepartmentResponseDto update(@RequestBody DepartmentRequestDto departmentRequestDto){

        log.info("부서정보 테이블(등록차량 추가정보) 수정 : {}",departmentRequestDto.toString());

        HashMap<String,Object> result  = departmentService.update(departmentRequestDto);

        return DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdepartment((List<Tdepartment>) result.get("tdepartment"))
                .build();
    }

    @DeleteMapping("/department")
    public DepartmentResponseDto delete(@RequestBody DepartmentRequestDto departmentRequestDto){

        log.info("부서정보 테이블(등록차량 추가정보) 삭제 : {}",departmentRequestDto.toString());

        HashMap<String,Object> result  = departmentService.delete(departmentRequestDto);

        return DepartmentResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
