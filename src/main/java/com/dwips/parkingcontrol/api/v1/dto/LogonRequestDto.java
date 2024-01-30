package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tlogon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogonRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Tlogon tlogon;

    private Long xindex;

    private String datefrom;

    private String dateto;

    private Long devicenum;
}
