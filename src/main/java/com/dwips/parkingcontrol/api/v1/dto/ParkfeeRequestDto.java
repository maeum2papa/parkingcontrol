package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tparkfee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkfeeRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Tparkfee tparkfee;

    private Long xindex;

}
