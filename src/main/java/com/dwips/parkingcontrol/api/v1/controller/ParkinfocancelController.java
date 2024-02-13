package com.dwips.parkingcontrol.api.v1.controller;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfocancelRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.ParkinfocancelResponseDto;
import com.dwips.parkingcontrol.api.v1.service.ParkinfocancelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ParkinfocancelController {

    private final CommonComponent commonComponent;

    private final ParkinfocancelService parkinfocancelService;

    @GetMapping("/parkinfocancel")
    public ParkinfocancelResponseDto search(@ModelAttribute ParkinfocancelRequestDto parkinfocancelRequestDto){


        commonComponent.logJson("카드정산취소 조회 요청",parkinfocancelRequestDto);

        HashMap<String, Object> result = parkinfocancelService.search(parkinfocancelRequestDto);

        ParkinfocancelResponseDto response = ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbcardinfo((List<Tbcardinfo>) result.get("tbcardinfo"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .tperiodmember((List<Tperiodmember>) result.get("tperiodmember"))
                .build();

        commonComponent.logJson("카드정산취소 조회 응답",response);

        return response;
    }

    @PostMapping("/parkinfocancel")
    public ParkinfocancelResponseDto save(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto) {

        commonComponent.logJson("카드정산취소 등록 요청",parkinfocancelRequestDto);

        HashMap<String, Object> result = parkinfocancelService.save(parkinfocancelRequestDto);

        ParkinfocancelResponseDto response = ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("카드정산취소 등록 응답",response);

        return response;
    }

    @PutMapping("/parkinfocancel")
    public ParkinfocancelResponseDto update(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto) {

        commonComponent.logJson("카드정산취소 수정 요청",parkinfocancelRequestDto);

        HashMap<String, Object> result = parkinfocancelService.update(parkinfocancelRequestDto);

        ParkinfocancelResponseDto response = ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("카드정산취소 수정 응답",response);

        return response;
    }

    @DeleteMapping("/parkinfocancel")
    public ParkinfocancelResponseDto delete(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto) {

        commonComponent.logJson("카드정산취소 삭제 요청",parkinfocancelRequestDto);

        HashMap<String, Object> result = parkinfocancelService.delete(parkinfocancelRequestDto);

        ParkinfocancelResponseDto response = ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();

        commonComponent.logJson("카드정산취소 삭제 응답",response);

        return response;
    }

}
