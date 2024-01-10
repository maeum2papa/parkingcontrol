package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkinfoRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Long qtype;

    private Long devicenum;

    private String mname;

    private String carnum;

    private String datefrom;

    private String dateto;

    private Tparkinfo tparkinfo;

    private Long option;

}
