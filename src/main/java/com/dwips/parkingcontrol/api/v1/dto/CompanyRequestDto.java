package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tcompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tcompany tcompany;

    private Long code;

    private String name;

}
