package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import com.dwips.parkingcontrol.api.v1.dto.DisaccountRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.DisaccountResponseDto;
import com.dwips.parkingcontrol.api.v1.service.DisaccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DisaccountController {

    private final DisaccountService disaccountService;

    @GetMapping("/disaccount")
    public DisaccountResponseDto search(@RequestBody DisaccountRequestDto disaccountRequestDto){

        log.info("할인계정 테이블(웹상에서 입주자가 사용) 조회 : {}",disaccountRequestDto.toString());

        HashMap<String,Object> result = disaccountService.search(disaccountRequestDto);

        return DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisaccount((List<Tdisaccount>) result.get("tdisaccount"))
                .build();
    }


    @PostMapping("/disaccount")
    public DisaccountResponseDto save(@RequestBody DisaccountRequestDto disaccountRequestDto){

        log.info("할인계정 테이블(웹상에서 입주자가 사용) 등록 : {}",disaccountRequestDto.toString());

        HashMap<String,Object> result = disaccountService.save(disaccountRequestDto);

        return DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisaccount((List<Tdisaccount>) result.get("tdisaccount"))
                .build();
    }


    @PutMapping("/disaccount")
    public DisaccountResponseDto update(@RequestBody DisaccountRequestDto disaccountRequestDto){

        log.info("할인계정 테이블(웹상에서 입주자가 사용) 수정 : {}",disaccountRequestDto.toString());

        HashMap<String,Object> result = disaccountService.update(disaccountRequestDto);

        return DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisaccount((List<Tdisaccount>) result.get("tdisaccount"))
                .build();
    }


    @DeleteMapping("/disaccount")
    public DisaccountResponseDto delete(@RequestBody DisaccountRequestDto disaccountRequestDto){

        log.info("할인계정 테이블(웹상에서 입주자가 사용) 삭제 : {}",disaccountRequestDto.toString());

        HashMap<String,Object> result = disaccountService.delete(disaccountRequestDto);

        return DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }

}
