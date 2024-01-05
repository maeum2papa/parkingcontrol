package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateSearchSummaryResponseDto {

    private Integer result;

    private Long totin;

    private Map<String, Long> totout;

    private List<Map<String,Long>> totpaytype;

    private Map<String, Long> totdiscount;

    private Map<String, Long> totgrace;

    private List<Map<String, Long>> totcartype;

    private List<Map<String, Long>> totparktype;

    private List<Map<String, Long>> totdevice;

    private List<Map<String, Long>> totdiscode;
}
