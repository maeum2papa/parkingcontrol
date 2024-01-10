package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ManagerRequestDto;

import java.util.HashMap;

public interface ManagerService {

    HashMap<String,Object> search(ManagerRequestDto managerRequestDto);

    HashMap<String,Object> save(ManagerRequestDto managerRequestDto);

    HashMap<String,Object> update(ManagerRequestDto managerRequestDto);

    HashMap<String,Object> delete(ManagerRequestDto managerRequestDto);

}
