package com.dwips.parkingcontrol.api.v1.controller;


import com.dwips.parkingcontrol.api.v1.domain.Tmanager;
import com.dwips.parkingcontrol.api.v1.dto.ManagerRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ManagerResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Manager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/manager")
    public ManagerResponseDto search(@RequestBody ManagerRequestDto managerRequestDto){

        log.info("담당자 테이블 조회 : {}",managerRequestDto.toString());

        HashMap<String,Object> result = managerService.search(managerRequestDto);

        return ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .tmanager((List<Tmanager>) result.get("tmanager"))
                .build();
    }

    @PostMapping("/manager")
    public ManagerResponseDto save(@RequestBody ManagerRequestDto managerRequestDto){

        log.info("담당자 테이블 조회 : {}",managerRequestDto.toString());

        HashMap<String,Object> result = managerService.save(managerRequestDto);

        return ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .tmanager((List<Tmanager>) result.get("tmanager"))
                .build();
    }

    @PutMapping("/manager")
    public ManagerResponseDto update(@RequestBody ManagerRequestDto managerRequestDto){

        log.info("담당자 테이블 수정 : {}",managerRequestDto.toString());

        HashMap<String,Object> result = managerService.update(managerRequestDto);

        return ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .tmanager((List<Tmanager>) result.get("tmanager"))
                .build();
    }

    @DeleteMapping("/manager")
    public ManagerResponseDto delete(@RequestBody ManagerRequestDto managerRequestDto){

        log.info("담당자 테이블 삭제 : {}",managerRequestDto.toString());

        HashMap<String,Object> result = managerService.delete(managerRequestDto);

        return ManagerResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }



}
