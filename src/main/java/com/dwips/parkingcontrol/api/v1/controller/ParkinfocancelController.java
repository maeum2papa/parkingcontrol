package com.dwips.parkingcontrol.api.v1.controller;

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

    private final ParkinfocancelService parkinfocancelService;

    @GetMapping("/parkinfocancel")
    public ParkinfocancelResponseDto search(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto){

        HashMap<String, Object> result = parkinfocancelService.search(parkinfocancelRequestDto);

        return ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .tbcardinfo((List<Tbcardinfo>) result.get("tbcardinfo"))
                .tparkinfo((List<Tparkinfo>) result.get("tparkinfo"))
                .tperiodmember((List<Tperiodmember>) result.get("tperiodmember"))
                .build();
    }

    @PostMapping("/parkinfocancel")
    public ParkinfocancelResponseDto save(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto) {

        HashMap<String, Object> result = parkinfocancelService.save(parkinfocancelRequestDto);

        return ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }

    @PutMapping("/parkinfocancel")
    public ParkinfocancelResponseDto update(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto) {

        HashMap<String, Object> result = parkinfocancelService.update(parkinfocancelRequestDto);

        return ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }

    @DeleteMapping("/parkinfocancel")
    public ParkinfocancelResponseDto delete(@RequestBody ParkinfocancelRequestDto parkinfocancelRequestDto) {

        HashMap<String, Object> result = parkinfocancelService.delete(parkinfocancelRequestDto);

        return ParkinfocancelResponseDto.builder()
                .result((Integer) result.get("result"))
                .xindex((Long) result.get("xindex"))
                .build();
    }

}
