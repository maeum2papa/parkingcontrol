package com.dwips.parkingcontrol.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountinfoRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long devicenum;

    private Long deptcode;

    private String disid;

    private Long pindex;

    private String datefrom;

    private String dateto;

}
