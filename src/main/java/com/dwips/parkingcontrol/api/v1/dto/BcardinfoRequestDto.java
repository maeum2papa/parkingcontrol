package com.dwips.parkingcontrol.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BcardinfoRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String carnum;

    private String rescode;

    private String cardid;

    private String cardname;

    private Long devicenum;

    private String datefrom;

    private String dateto;
}
