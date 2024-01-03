package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateAndOutResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;

public interface CalculateAndOutService {

    public CalculateAndOutResponseDto calculate(CalculateAndOutRequestDto calculateAndOutRequestDto);

    public CalculateAndOutResponseDto out(CalculateAndOutRequestDto calculateAndOutRequestDto);
}
