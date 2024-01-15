package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.WelfareRequestDto;

import java.util.HashMap;
import java.util.Objects;

public interface WelfareService{

    HashMap<String, Object> search(WelfareRequestDto welfareRequestDto);
    HashMap<String, Object> save(WelfareRequestDto welfareRequestDto);
    HashMap<String, Object> update(WelfareRequestDto welfareRequestDto);
    HashMap<String, Object> delete(WelfareRequestDto welfareRequestDto);
}
