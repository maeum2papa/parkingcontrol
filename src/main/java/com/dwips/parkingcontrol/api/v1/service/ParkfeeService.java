package com.dwips.parkingcontrol.api.v1.service;


import com.dwips.parkingcontrol.api.v1.dto.ParkfeeRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface ParkfeeService {

    HashMap<String,Object> search(ParkfeeRequestDto parkfeeRequestDto);

    HashMap<String,Object> save(ParkfeeRequestDto parkfeeRequestDto);

    HashMap<String,Object> update(ParkfeeRequestDto parkfeeRequestDto);

    HashMap<String,Object> delete(ParkfeeRequestDto parkfeeRequestDto);
}
