package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodmemberExtendRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String carnum;

    private Tperiodmember tperiodmember;

    private Tperiodaccount tperiodaccount;

    private Tbcardinfo tbcardinfo;
}
