package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.BcardinfoRequestDto;

import java.util.HashMap;

public interface BcardinfoService {

    HashMap<String,Object> search(BcardinfoRequestDto bcardinfoRequestDto);
}
