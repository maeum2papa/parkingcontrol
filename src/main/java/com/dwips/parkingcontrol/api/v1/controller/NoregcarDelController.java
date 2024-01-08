package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.dto.NoregcarDelRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarResponseDto;
import com.dwips.parkingcontrol.api.v1.service.NoregcarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NoregcarDelController {

    private final NoregcarService noregcarService;

    @DeleteMapping("/noregcardel")
    public NoregcarResponseDto extend(@RequestBody NoregcarDelRequestDto noregcardelRequestDto){

        log.info("미인식차량 삭제 : {}",noregcardelRequestDto.toString());

        HashMap<String, Object> result = noregcarService.delete(noregcardelRequestDto);

        return NoregcarResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }
}
