package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tholiday;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidayRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String year;

    private Tholiday tholiday;

    private Long xindex;

}
