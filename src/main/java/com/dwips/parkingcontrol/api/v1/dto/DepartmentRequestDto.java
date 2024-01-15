package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tdepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private Tdepartment tdepartment;

    private Long ccode;

    private String cname;

    private Long code;

    private String name;

}
