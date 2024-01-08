package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.NoregcarDelRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarSearchRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberRequestDto;

import java.util.HashMap;

public interface NoregcarService {

    HashMap<String,Object> save(NoregcarRequestDto noregcarRequestDto);

    HashMap<String,Object> delete(NoregcarDelRequestDto noregcarDelRequestDto);

    HashMap<String,Object> search(NoregcarSearchRequestDto noregcarSearchRequestDto);


}
