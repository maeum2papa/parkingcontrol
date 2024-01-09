package com.dwips.parkingcontrol.api.v1.dto;


import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodmemberInOutRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long qtype;

    private String carnum;

    private Long cardid;

    private String name;

    private Long xindex;

    private String datefrom;

    private String dateto;
}
