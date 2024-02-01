package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tgateinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GateinfoRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Tgateinfo tgateinfo;

    private Long xindex;
}
