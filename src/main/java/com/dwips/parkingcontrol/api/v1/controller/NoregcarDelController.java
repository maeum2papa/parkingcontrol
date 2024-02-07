package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final NoregcarService noregcarService;

    @DeleteMapping("/noregcardel")
    public NoregcarResponseDto extend(@RequestBody NoregcarDelRequestDto noregcardelRequestDto){

        commonComponent.logJson("미인식차량 삭제 요청",noregcardelRequestDto);

        HashMap<String, Object> result = noregcarService.delete(noregcardelRequestDto);

        NoregcarResponseDto response = NoregcarResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("미인식차량 등록 응답",response);

        return response;
    }
}
