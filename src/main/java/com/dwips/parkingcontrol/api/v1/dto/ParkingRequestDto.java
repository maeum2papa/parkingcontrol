package com.dwips.parkingcontrol.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingRequestDto {

    private Long sitenum;

    private Long groupnum;

}
