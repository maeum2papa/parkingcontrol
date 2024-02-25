package com.dwips.parkingcontrol.api.v1.controller;


import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tmanager;
import com.dwips.parkingcontrol.api.v1.dto.ManagerRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ManagerResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Manager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ManagerController {

    private final CommonComponent commonComponent;

    private final ManagerService managerService;

    @GetMapping("/manager")
    public ManagerResponseDto search(@ModelAttribute ManagerRequestDto managerRequestDto){

        commonComponent.logJson("담당자 테이블 조회 요청",managerRequestDto);

        HashMap<String,Object> result = managerService.search(managerRequestDto);

        ManagerResponseDto response = ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .tmanager((List<Tmanager>) result.get("tmanager"))
                .build();

        commonComponent.logJson("담당자 테이블 조회 응답",response);

        return response;
    }

    @PostMapping("/manager")
    public ManagerResponseDto save(@RequestBody ManagerRequestDto managerRequestDto){

        commonComponent.logJson("담당자 테이블 등록 요청",managerRequestDto);

        HashMap<String,Object> result = managerService.save(managerRequestDto);

        ManagerResponseDto response = ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .tmanager((List<Tmanager>) result.get("tmanager"))
                .build();

        commonComponent.logJson("담당자 테이블 등록 응답",response);

        return response;
    }

    @PutMapping("/manager")
    public ManagerResponseDto update(@RequestBody ManagerRequestDto managerRequestDto){

        commonComponent.logJson("담당자 테이블 수정 요청",managerRequestDto);

        HashMap<String,Object> result = managerService.update(managerRequestDto);

        ManagerResponseDto response = ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .tmanager((List<Tmanager>) result.get("tmanager"))
                .build();

        commonComponent.logJson("담당자 테이블 수정 응답",response);

        return response;
    }

    @DeleteMapping("/manager")
    public ManagerResponseDto delete(@RequestBody ManagerRequestDto managerRequestDto){

        commonComponent.logJson("담당자 테이블 삭제 요청",managerRequestDto);

        HashMap<String,Object> result = managerService.delete(managerRequestDto);

        ManagerResponseDto response = ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("담당자 테이블 삭제 응답",response);

        return response;
    }



}
