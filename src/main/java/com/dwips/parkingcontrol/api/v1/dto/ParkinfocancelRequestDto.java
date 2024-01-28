package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkinfocancelRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private String acceptnum;

    private String carnum;

    private String datefrom;

    private String dateto;

    private Tparkinfo tparkinfo;

    private Tbcardinfo tbcardinfo;

}
