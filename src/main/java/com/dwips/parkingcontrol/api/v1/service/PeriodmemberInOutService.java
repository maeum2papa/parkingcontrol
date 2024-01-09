package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberInOutRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberRequestDto;

import java.util.HashMap;

public interface PeriodmemberInOutService {

    HashMap<String,Object> search(PeriodmemberInOutRequestDto periodmemberInOutRequestDto);

}
