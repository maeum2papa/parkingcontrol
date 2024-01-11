package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.PeriodaccountRequestDto;

import java.util.HashMap;

public interface PeriodaccountService {

    HashMap<String,Object> search(PeriodaccountRequestDto periodaccountRequestDto);

    HashMap<String,Object> save(PeriodaccountRequestDto periodaccountRequestDto);
}
