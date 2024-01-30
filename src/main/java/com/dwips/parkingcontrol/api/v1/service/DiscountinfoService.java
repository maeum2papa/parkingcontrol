package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.DiscountinfoRequestDto;

import java.util.HashMap;

public interface DiscountinfoService {
    HashMap<String, Object> search(DiscountinfoRequestDto discountinfoRequestDto);
}
