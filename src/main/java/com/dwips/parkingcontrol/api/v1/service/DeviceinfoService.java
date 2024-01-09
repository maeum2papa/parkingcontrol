package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.DeviceinfoRequestDto;

import java.util.HashMap;

public interface DeviceinfoService {

    HashMap<String,Object> search(DeviceinfoRequestDto deviceinfoRequestDto);

    HashMap<String,Object> save(DeviceinfoRequestDto deviceinfoRequestDto);

    HashMap<String,Object> update(DeviceinfoRequestDto deviceinfoRequestDto);

    HashMap<String,Object> delete(DeviceinfoRequestDto deviceinfoRequestDto);

}
