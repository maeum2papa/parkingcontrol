package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ParkunpaiedRequestDto;

import java.util.HashMap;

public interface ParkunpaiedService {
    HashMap<String, Object> search(ParkunpaiedRequestDto parkunpaiedRequestDto);

    HashMap<String, Object> save(ParkunpaiedRequestDto parkunpaiedRequestDto);

    HashMap<String, Object> delete(ParkunpaiedRequestDto parkunpaiedRequestDto);
}
