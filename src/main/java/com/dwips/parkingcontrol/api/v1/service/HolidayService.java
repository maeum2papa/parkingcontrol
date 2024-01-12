package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.HolidayRequestDto;

import java.util.HashMap;

public interface HolidayService {

    HashMap<String,Object> search(HolidayRequestDto holidayRequestDto);
    HashMap<String,Object> save(HolidayRequestDto holidayRequestDto);
    HashMap<String,Object> update(HolidayRequestDto holidayRequestDto);
    HashMap<String,Object> delete(HolidayRequestDto holidayRequestDto);


}
