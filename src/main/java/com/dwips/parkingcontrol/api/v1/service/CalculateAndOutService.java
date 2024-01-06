package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;

import java.util.HashMap;

public interface CalculateAndOutService {

    public HashMap<String,Object> calculate(CalculateAndOutRequestDto calculateAndOutRequestDto);

    public HashMap<String,Object> out(CalculateAndOutRequestDto calculateAndOutRequestDto);
}
