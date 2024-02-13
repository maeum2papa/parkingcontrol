package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tping;
import com.dwips.parkingcontrol.api.v1.domain.Tvaninfo;
import com.dwips.parkingcontrol.api.v1.dto.PingRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PingResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.VaninfoRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.VaninfoResponseDto;
import com.dwips.parkingcontrol.api.v1.service.VaninfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VaninfoController {

    private final CommonComponent commonComponent;
    private VaninfoService vaninfoService;

    @GetMapping("/vaninfo")
    public VaninfoResponseDto search(@ModelAttribute VaninfoRequestDto vaninfoRequestDto){

        commonComponent.logJson("벤사정보 조회 요청",vaninfoRequestDto);

        HashMap<String, Object> result = vaninfoService.search(vaninfoRequestDto);

        VaninfoResponseDto response = VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tvaninfo((List<Tvaninfo>) result.get("tvaninfo"))
                .build();

        commonComponent.logJson("벤사정보 조회 응답",response);

        return response;

    }

    @PostMapping("/vaninfo")
    public VaninfoResponseDto save(@RequestBody VaninfoRequestDto vaninfoRequestDto){

        commonComponent.logJson("벤사정보 등록 요청",vaninfoRequestDto);

        HashMap<String, Object> result = vaninfoService.save(vaninfoRequestDto);

        VaninfoResponseDto response = VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("벤사정보 등록 응답",response);

        return response;
    }

    @PutMapping("/vaninfo")
    public VaninfoResponseDto update(@RequestBody VaninfoRequestDto vaninfoRequestDto){

        commonComponent.logJson("벤사정보 수정 요청",vaninfoRequestDto);

        HashMap<String, Object> result = vaninfoService.update(vaninfoRequestDto);

        VaninfoResponseDto response = VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("벤사정보 수정 응답",response);

        return response;
    }

    @DeleteMapping("/vaninfo")
    public VaninfoResponseDto delete(@RequestBody VaninfoRequestDto vaninfoRequestDto){

        commonComponent.logJson("벤사정보 삭제 요청",vaninfoRequestDto);

        HashMap<String, Object> result = vaninfoService.delete(vaninfoRequestDto);

        VaninfoResponseDto response = VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("벤사정보 삭제 응답",response);

        return response;
    }

}
