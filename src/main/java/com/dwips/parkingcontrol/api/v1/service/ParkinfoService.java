package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ParkinfoRequestDto;

import java.util.HashMap;

public interface ParkinfoService {

    HashMap<String,Object> search(ParkinfoRequestDto parkinfoRequestDto);

    HashMap<String,Object> save(ParkinfoRequestDto parkinfoRequestDto);

    HashMap<String,Object> update(ParkinfoRequestDto parkinfoRequestDto);

    HashMap<String,Object> delete(ParkinfoRequestDto parkinfoRequestDto);
}
