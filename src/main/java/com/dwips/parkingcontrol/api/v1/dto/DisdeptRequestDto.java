package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tdisdept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisdeptRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tdisdept tdisdept;

    private Long deptcode;

    private String deptname;
}
