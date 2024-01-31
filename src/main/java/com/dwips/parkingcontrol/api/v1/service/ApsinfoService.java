package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ApsinfoRequestDto;

import java.util.HashMap;

public interface ApsinfoService {
    HashMap<String, Object> save(ApsinfoRequestDto apsinfoRequestDto);

    HashMap<String, Object> update(ApsinfoRequestDto apsinfoRequestDto);
}
