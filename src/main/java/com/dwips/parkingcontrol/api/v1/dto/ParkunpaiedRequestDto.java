package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tparkunpaied;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkunpaiedRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long devicenum;

    private String carnum;

    private String datefrom;

    private String dateto;

    private Long xindex;

    private Tparkunpaied tparkunpaied;
}
