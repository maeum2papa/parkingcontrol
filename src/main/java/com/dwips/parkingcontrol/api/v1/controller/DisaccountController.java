package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
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

    private final CommonComponent commonComponent;

    private final DisaccountService disaccountService;

    @GetMapping("/disaccount")
    public DisaccountResponseDto search(@RequestBody DisaccountRequestDto disaccountRequestDto){

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 조회 요청",disaccountRequestDto);

        HashMap<String,Object> result = disaccountService.search(disaccountRequestDto);

        DisaccountResponseDto response = DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisaccount((List<Tdisaccount>) result.get("tdisaccount"))
                .build();

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 조회 응답",response);

        return response;
    }


    @PostMapping("/disaccount")
    public DisaccountResponseDto save(@RequestBody DisaccountRequestDto disaccountRequestDto){

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 등록 요청",disaccountRequestDto);

        HashMap<String,Object> result = disaccountService.save(disaccountRequestDto);

        DisaccountResponseDto response = DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisaccount((List<Tdisaccount>) result.get("tdisaccount"))
                .build();

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 등록 응답",response);

        return response;
    }


    @PutMapping("/disaccount")
    public DisaccountResponseDto update(@RequestBody DisaccountRequestDto disaccountRequestDto){

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 수정 요청",disaccountRequestDto);

        HashMap<String,Object> result = disaccountService.update(disaccountRequestDto);

        DisaccountResponseDto response = DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .tdisaccount((List<Tdisaccount>) result.get("tdisaccount"))
                .build();

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 수정 응답",response);

        return response;
    }


    @DeleteMapping("/disaccount")
    public DisaccountResponseDto delete(@RequestBody DisaccountRequestDto disaccountRequestDto){

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 삭제 요청",disaccountRequestDto);

        HashMap<String,Object> result = disaccountService.delete(disaccountRequestDto);

        DisaccountResponseDto response = DisaccountResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("할인계정 테이블(웹상에서 입주자가 사용) 수정 응답",response);

        return response;
    }

}
