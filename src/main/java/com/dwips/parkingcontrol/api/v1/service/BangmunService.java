package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.BangmunRequestDto;

import java.util.HashMap;

public interface BangmunService {

    HashMap<String,Object> search(BangmunRequestDto bangmunRequestDto);

    HashMap<String,Object> save(BangmunRequestDto bangmunRequestDto);

    HashMap<String,Object> update(BangmunRequestDto bangmunRequestDto);

    HashMap<String,Object> delete(BangmunRequestDto bangmunRequestDto);

}
