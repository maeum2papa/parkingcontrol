package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.repository.PeriodparktimeRequestDto;

import java.util.HashMap;

public interface PeriodparktimeService {

    HashMap<String,Object> search(PeriodparktimeRequestDto periodparktimeRequestDto);

    HashMap<String,Object> save(PeriodparktimeRequestDto periodparktimeRequestDto);

    HashMap<String,Object> update(PeriodparktimeRequestDto periodparktimeRequestDto);

    HashMap<String,Object> delete(PeriodparktimeRequestDto periodparktimeRequestDto);

}
