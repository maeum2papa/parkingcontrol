package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tparkings;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import com.dwips.parkingcontrol.api.v1.dto.ParkingRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TparkingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService{

    private final TparkingsRepository tparkingsRepository;

    @Override
    public HashMap<String, Object> search(ParkingRequestDto parkingRequestDto) {

        Integer result = 0;

        List<Tparkings> tparkingsList = tparkingsRepository.findAll();

        if(!tparkingsList.isEmpty()){
            result = 1;
        }else{
            tparkingsList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkings",tparkingsList);

        return resultMap;

    }
}
