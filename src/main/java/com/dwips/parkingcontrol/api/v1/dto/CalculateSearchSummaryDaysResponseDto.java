package com.dwips.parkingcontrol.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_EMPTY)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateSearchSummaryDaysResponseDto {

    private Integer result;

    private HashMap<String, Long> totin;

    private HashMap<String, Map<String,Long>> totout;

    private HashMap<String, List<Map<String, Long>>> totpaytype;

    private HashMap<String, Map<String,Long>> totdiscount;

    private HashMap<String, Map<String,Long>> totgrace;

    private HashMap<String, List<Map<String, Long>>> totcartype;

    private HashMap<String, List<Map<String, Long>>> totparktype;

    private HashMap<String, List<Map<String, Long>>> totdevice;

    private HashMap<String, List<Map<String, Long>>> totdiscode;

}
