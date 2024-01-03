package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.CalculateRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CalculateResponseDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;

public interface CalculateService {
        public CalculateResponseDto calculate(CalculateRequestDto calculateRequestDto);
}
