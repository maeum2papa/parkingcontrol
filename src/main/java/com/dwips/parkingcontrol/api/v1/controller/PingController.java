package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tping;
import com.dwips.parkingcontrol.api.v1.dto.PingRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PingResponseDto;
import com.dwips.parkingcontrol.api.v1.service.PingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PingController {
    private final CommonComponent commonComponent;

    private final PingService pingService;

    @GetMapping("/ping")
    public PingResponseDto search(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 조회 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.search(pingRequestDto);

        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 조회 응답",response);

        return response;
    }

    @PostMapping("/ping")
    public PingResponseDto save(@RequestBody PingRequestDto pingRequestDto){

        
        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 등록 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.save(pingRequestDto);

        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 등록 응답",response);

        return response;
    }

    @PutMapping("/ping")
    public PingResponseDto update(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 수정 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.update(pingRequestDto);

        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 수정 응답",response);

        return response;
    }

    @DeleteMapping("/ping")
    public PingResponseDto delete(@RequestBody PingRequestDto pingRequestDto){

        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 삭제 요청",pingRequestDto);


        HashMap<String, Object> result = pingService.delete(pingRequestDto);

        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();

        commonComponent.logJson("현재 입출차 및 정산 테이블 인덱스 삭제 응답",response);

        return response;
    }


    @GetMapping("/ping/xparkin")
    public PingResponseDto xparkin(@RequestBody PingRequestDto pingRequestDto){

        commonComponent.logJson("xparkin 모니터링 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.xparkin(pingRequestDto);


        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();


        commonComponent.logJson("xparkin 모니터링 응답",response);

        return response;
    }


    @GetMapping("/ping/xparkinfo")
    public PingResponseDto xparkinfo(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("xparkinfo 모니터링 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.xparkinfo(pingRequestDto);


        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("xparkinfo 모니터링 응답",response);

        return response;
    }


    @GetMapping("/ping/xparkcal")
    public PingResponseDto xparkcal(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("xparkcal 모니터링 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.xparkcal(pingRequestDto);


        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("xparkcal 모니터링 응답",response);

        return response;
    }

    @GetMapping("/ping/xperiodin")
    public PingResponseDto xperiodin(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("xperiodin 모니터링 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.xperiodin(pingRequestDto);


        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("xperiodin 모니터링 응답",response);

        return response;
    }

    @GetMapping("/ping/xperiodout")
    public PingResponseDto xperiodout(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("xperiodout 모니터링 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.xperiodout(pingRequestDto);


        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("xperiodout 모니터링 응답",response);

        return response;
    }

    @GetMapping("/ping/xcredit")
    public PingResponseDto xcredit(@RequestBody PingRequestDto pingRequestDto){


        commonComponent.logJson("xcredit 모니터링 요청",pingRequestDto);

        HashMap<String, Object> result = pingService.xcredit(pingRequestDto);


        PingResponseDto response = PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();

        commonComponent.logJson("xcredit 모니터링 응답",response);

        return response;
    }

}
