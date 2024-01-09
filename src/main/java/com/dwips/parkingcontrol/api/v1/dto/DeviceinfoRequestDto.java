package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tdeviceinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceinfoRequestDto {

    private Long xindex;

    private Long sitenum;

    private Long groupnum;

    private Tdeviceinfo tdeviceinfo;
}
