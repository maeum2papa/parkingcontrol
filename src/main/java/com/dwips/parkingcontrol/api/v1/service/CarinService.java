package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;

import java.util.HashMap;

public interface CarinService {

    public HashMap<Object, Object> saveCar(CarinRequestDto carinRequestDto);
}
