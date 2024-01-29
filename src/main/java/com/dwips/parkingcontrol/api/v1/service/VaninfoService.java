package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.VaninfoRequestDto;

import java.util.HashMap;

public interface VaninfoService {

    HashMap<String, Object> search(VaninfoRequestDto vaninfoRequestDto);

    HashMap<String, Object> save(VaninfoRequestDto vaninfoRequestDto);

    HashMap<String, Object> update(VaninfoRequestDto vaninfoRequestDto);

    HashMap<String, Object> delete(VaninfoRequestDto vaninfoRequestDto);
}
