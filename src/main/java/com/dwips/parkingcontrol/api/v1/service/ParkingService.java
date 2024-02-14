package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ParkingRequestDto;

import java.util.HashMap;

public interface ParkingService {
    HashMap<String,Object> search(ParkingRequestDto parkingRequestDto);
}
