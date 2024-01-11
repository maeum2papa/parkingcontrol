package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.DisdeptRequestDto;

import java.util.HashMap;

public interface DisdeptService {

    HashMap<String,Object> search(DisdeptRequestDto disdpeptRequestDto);

    HashMap<String,Object> save(DisdeptRequestDto disdpeptRequestDto);

    HashMap<String,Object> update(DisdeptRequestDto disdpeptRequestDto);

    HashMap<String,Object> delete(DisdeptRequestDto disdpeptRequestDto);

}
