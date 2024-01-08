package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberExtendRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberRequestDto;

import java.util.HashMap;

public interface PeriodmemberService {

    HashMap<String,Object> search(PeriodmemberRequestDto periodmemberRequestDto);

    HashMap<String,Object> delete(PeriodmemberRequestDto periodmemberRequestDto);

    HashMap<String, Object> extend(PeriodmemberExtendRequestDto periodmemberExtendRequestDto);
}
