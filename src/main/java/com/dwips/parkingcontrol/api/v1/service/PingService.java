package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.PingRequestDto;

import java.util.HashMap;

public interface PingService {

    HashMap<String,Object> search(PingRequestDto pingRequestDto);
    HashMap<String,Object> save(PingRequestDto pingRequestDto);
    HashMap<String,Object> update(PingRequestDto pingRequestDto);
    HashMap<String,Object> delete(PingRequestDto pingRequestDto);
    HashMap<String, Object> xparkin(PingRequestDto pingRequestDto);

    HashMap<String, Object> xparkinfo(PingRequestDto pingRequestDto);

    HashMap<String, Object> xparkcal(PingRequestDto pingRequestDto);

    HashMap<String, Object> xperiodin(PingRequestDto pingRequestDto);

    HashMap<String, Object> xperiodout(PingRequestDto pingRequestDto);

    HashMap<String, Object> xcredit(PingRequestDto pingRequestDto);
}
