package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tparkconfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkconfigRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tparkconfig tparkconfig;
}
