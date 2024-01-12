package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.BlackListRequestDto;

import java.util.HashMap;

public interface BlacklistService {

    HashMap<String, Object> search(BlackListRequestDto blackListRequestDto);

    HashMap<String, Object> save(BlackListRequestDto blackListRequestDto);

    HashMap<String, Object> update(BlackListRequestDto blackListRequestDto);

    HashMap<String, Object> delete(BlackListRequestDto blackListRequestDto);
}
