package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tblacklist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlackListRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tblacklist tblacklist;

    private String datefrom;

    private String dateto;

    private String carnum;
}
