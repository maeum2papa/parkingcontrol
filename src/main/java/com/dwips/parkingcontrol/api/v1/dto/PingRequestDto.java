package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PingRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Tping tping;

    private Long xindex;

    private Long xparkin;

    private Long xparkinfo;

    private Long xparkcal;

    private Long xperiodin;

    private Long xperiodout;

    private Long xcredit;



}
