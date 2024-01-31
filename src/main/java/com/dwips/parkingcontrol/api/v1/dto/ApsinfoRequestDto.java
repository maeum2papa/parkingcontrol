package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tapsinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApsinfoRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String apsip;

    private Long devicenum;

    private Tapsinfo tapsinfo;

}
