package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.ParkinfocancelRequestDto;

import java.util.HashMap;

public interface ParkinfocancelService {

    HashMap<String,Object> search(ParkinfocancelRequestDto parkinfocancelRequestDto);

    HashMap<String,Object> save(ParkinfocancelRequestDto parkinfocancelRequestDto);

    HashMap<String,Object> update(ParkinfocancelRequestDto parkinfocancelRequestDto);

    HashMap<String,Object> delete(ParkinfocancelRequestDto parkinfocancelRequestDto);
}
