package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateAndOutRequestDto {

    @JsonProperty("IOTYPE")
    private String IOTYPE;

    private Long sitenum;

    private Long groupnum;

    private Long devicenum;

    private Tparkinfo tparkinfo;

    private Tbcardinfo tbcardinfo;

    private Tdiscountinfo tdiscountinfo;

    private Tperiodinout tperiodinout;
}
