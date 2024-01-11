package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodaccountRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String carnum;

    private Long pflag;

    private String datefrom;

    private String dateto;

    private Tperiodaccount tperiodaccount;

}
