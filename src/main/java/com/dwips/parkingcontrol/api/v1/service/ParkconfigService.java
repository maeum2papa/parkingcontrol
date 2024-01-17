package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ParkconfigRequestDto;

import java.util.HashMap;
import java.util.Objects;

public interface ParkconfigService {

    HashMap<String, Object> search(ParkconfigRequestDto parkconfigRequestDto);
    HashMap<String, Object> save(ParkconfigRequestDto parkconfigRequestDto);
    HashMap<String, Object> update(ParkconfigRequestDto parkconfigRequestDto);
    HashMap<String, Object> delete(ParkconfigRequestDto parkconfigRequestDto);
}
