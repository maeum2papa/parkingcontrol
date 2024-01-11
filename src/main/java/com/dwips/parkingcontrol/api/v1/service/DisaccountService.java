package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.DisaccountRequestDto;

import java.util.HashMap;

public interface DisaccountService {

    HashMap<String,Object> search(DisaccountRequestDto disaccountRequestDto);

    HashMap<String,Object> save(DisaccountRequestDto disaccountRequestDto);

    HashMap<String,Object> update(DisaccountRequestDto disaccountRequestDto);

    HashMap<String,Object> delete(DisaccountRequestDto disaccountRequestDto);
}
