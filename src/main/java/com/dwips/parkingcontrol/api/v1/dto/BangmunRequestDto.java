package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbangmun;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.PrimitiveIterator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BangmunRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tbangmun tbangmun;

    private String carnum;

    private String datefrom;

    private String dateto;

    private String visitplace;
}
