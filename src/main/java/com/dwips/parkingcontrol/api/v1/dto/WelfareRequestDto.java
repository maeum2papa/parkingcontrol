package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WelfareRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Twelfare twelfare;

    private String datefrom;

    private String dateto;

    private String carnum;

    private String name;

    private Long diskey;

}
