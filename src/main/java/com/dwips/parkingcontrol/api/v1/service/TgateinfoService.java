package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.GateinfoRequestDto;

import java.util.HashMap;

public interface TgateinfoService {
    HashMap<String, Object> search(GateinfoRequestDto gateinfoRequestDto);

    HashMap<String, Object> save(GateinfoRequestDto gateinfoRequestDto);

    HashMap<String, Object> update(GateinfoRequestDto gateinfoRequestDto);

    HashMap<String, Object> delete(GateinfoRequestDto gateinfoRequestDto);
}
