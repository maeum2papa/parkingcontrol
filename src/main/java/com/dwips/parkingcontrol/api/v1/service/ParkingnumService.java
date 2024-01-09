package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ParkingnumRequestDto;

import java.util.HashMap;

public interface ParkingnumService {

    HashMap<String, Object> search(ParkingnumRequestDto parkingnumRequestDto);

    HashMap<String, Object> update(ParkingnumRequestDto parkingnumRequestDto);

    HashMap<String, Object> save(ParkingnumRequestDto parkingnumRequestDto);
}
