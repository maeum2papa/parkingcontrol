package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.CalculateSearchRequestDto;

import java.util.Map;

public interface CalculateSearchService {

    Map<String, Object> defaultSearch(CalculateSearchRequestDto calculateSearchRequestDto);

    Map<String, Object> summarySearch(CalculateSearchRequestDto calculateSearchRequestDto);

    Map<String, Object> summaryDaysSearch(CalculateSearchRequestDto calculateSearchRequestDto);

    Map<String, Object> deptcodesSearch(CalculateSearchRequestDto calculateSearchRequestDto);

    Map<String, Object> midsSearch(CalculateSearchRequestDto calculateSearchRequestDto);
}
