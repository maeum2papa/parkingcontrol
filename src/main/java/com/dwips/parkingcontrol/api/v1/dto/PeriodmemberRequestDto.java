package com.dwips.parkingcontrol.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodmemberRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String carnum; //single or multi

    private String company; //회사명

    private String department; //부서명

    private String name; //이름

    private String datefrom;

    private String dateto;

    private Long xindex;
}
