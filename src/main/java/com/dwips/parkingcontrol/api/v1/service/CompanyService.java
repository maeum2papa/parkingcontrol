package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.CompanyRequestDto;

import java.util.HashMap;

public interface CompanyService {

    HashMap<String,Object> search(CompanyRequestDto companyRequestDto);

    HashMap<String,Object> save(CompanyRequestDto companyRequestDto);

    HashMap<String,Object> update(CompanyRequestDto companyRequestDto);

    HashMap<String,Object> delete(CompanyRequestDto companyRequestDto);
}
