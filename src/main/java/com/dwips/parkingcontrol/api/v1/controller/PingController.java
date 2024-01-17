package com.dwips.parkingcontrol.api.v1.controller;

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

    private final PingService pingService;

    @GetMapping("/ping")
    public PingResponseDto search(@RequestBody PingRequestDto pingRequestDto){

        log.info("현재 입출차 및 정산 테이블 인덱스 조회 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.search(pingRequestDto);

        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

    @PostMapping("/ping")
    public PingResponseDto save(@RequestBody PingRequestDto pingRequestDto){

        log.info("현재 입출차 및 정산 테이블 인덱스 등록 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.save(pingRequestDto);

        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

    @PutMapping("/ping")
    public PingResponseDto update(@RequestBody PingRequestDto pingRequestDto){

        log.info("현재 입출차 및 정산 테이블 인덱스 수정 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.update(pingRequestDto);

        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

    @DeleteMapping("/ping")
    public PingResponseDto delete(@RequestBody PingRequestDto pingRequestDto){

        log.info("현재 입출차 및 정산 테이블 인덱스 삭제 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.delete(pingRequestDto);

        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .build();
    }


    @GetMapping("/ping/xparkin")
    public PingResponseDto xparkin(@RequestBody PingRequestDto pingRequestDto){

        log.info("xparkin 모니터링 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.xparkin(pingRequestDto);


        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }


    @GetMapping("/ping/xparkinfo")
    public PingResponseDto xparkinfo(@RequestBody PingRequestDto pingRequestDto){

        log.info("xparkinfo 모니터링 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.xparkinfo(pingRequestDto);


        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }


    @GetMapping("/ping/xparkcal")
    public PingResponseDto xparkcal(@RequestBody PingRequestDto pingRequestDto){

        log.info("xparkcal 모니터링 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.xparkcal(pingRequestDto);


        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

    @GetMapping("/ping/xperiodin")
    public PingResponseDto xperiodin(@RequestBody PingRequestDto pingRequestDto){

        log.info("xperiodin 모니터링 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.xperiodin(pingRequestDto);


        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

    @GetMapping("/ping/xperiodout")
    public PingResponseDto xperiodout(@RequestBody PingRequestDto pingRequestDto){

        log.info("xperiodout 모니터링 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.xperiodout(pingRequestDto);


        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

    @GetMapping("/ping/xcredit")
    public PingResponseDto xcredit(@RequestBody PingRequestDto pingRequestDto){

        log.info("xcredit 모니터링 : {}",pingRequestDto.toString());

        HashMap<String, Object> result = pingService.xcredit(pingRequestDto);


        return PingResponseDto.builder()
                .result((Integer) result.get("result"))
                .tping((List<Tping>) result.get("tping"))
                .build();
    }

}
