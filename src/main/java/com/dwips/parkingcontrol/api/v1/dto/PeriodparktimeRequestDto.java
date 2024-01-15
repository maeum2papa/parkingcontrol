package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodparktime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodparktimeRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tperiodparktime tperiodparktime;

    private Long code;
}
