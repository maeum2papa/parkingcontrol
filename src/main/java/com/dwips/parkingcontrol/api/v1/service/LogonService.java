package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.LogonRequestDto;

import java.util.HashMap;

public interface LogonService {
    HashMap<String, Object> search(LogonRequestDto logonRequestDto);

    HashMap<String, Object> save(LogonRequestDto logonRequestDto);

    HashMap<String, Object> delete(LogonRequestDto logonRequestDto);
}
