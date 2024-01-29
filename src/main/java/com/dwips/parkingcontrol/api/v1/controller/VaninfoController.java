package com.dwips.parkingcontrol.api.v1.controller;

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

    private VaninfoService vaninfoService;

    @GetMapping("/vaninfo")
    public VaninfoResponseDto search(@RequestBody VaninfoRequestDto vaninfoRequestDto){
        log.info("벤사정보 조회 : {}",vaninfoRequestDto.toString());

        HashMap<String, Object> result = vaninfoService.search(vaninfoRequestDto);

        return VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .tvaninfo((List<Tvaninfo>) result.get("tvaninfo"))
                .build();
    }

    @PostMapping("/vaninfo")
    public VaninfoResponseDto save(@RequestBody VaninfoRequestDto vaninfoRequestDto){
        log.info("벤사정보 등록 : {}",vaninfoRequestDto.toString());

        HashMap<String, Object> result = vaninfoService.save(vaninfoRequestDto);

        return VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }

    @PutMapping("/vaninfo")
    public VaninfoResponseDto update(@RequestBody VaninfoRequestDto vaninfoRequestDto){
        log.info("벤사정보 수정 : {}",vaninfoRequestDto.toString());

        HashMap<String, Object> result = vaninfoService.update(vaninfoRequestDto);

        return VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }

    @DeleteMapping("/vaninfo")
    public VaninfoResponseDto delete(@RequestBody VaninfoRequestDto vaninfoRequestDto){
        log.info("벤사정보 삭제 : {}",vaninfoRequestDto.toString());

        HashMap<String, Object> result = vaninfoService.delete(vaninfoRequestDto);

        return VaninfoResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }

}
