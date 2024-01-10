package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.DiscountRequestDto;

import java.util.HashMap;
import java.util.Objects;

public interface DiscountService {

    HashMap<String, Object> search(DiscountRequestDto discountRequestDto);

    HashMap<String, Object> save(DiscountRequestDto discountRequestDto);

    HashMap<String, Object> update(DiscountRequestDto discountRequestDto);

    HashMap<String, Object> delete(DiscountRequestDto discountRequestDto);
}
