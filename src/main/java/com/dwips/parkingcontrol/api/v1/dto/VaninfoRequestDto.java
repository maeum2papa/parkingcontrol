package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tvaninfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaninfoRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long vancode;

    private Tvaninfo tvaninfo;

    private Long xindex;
}
