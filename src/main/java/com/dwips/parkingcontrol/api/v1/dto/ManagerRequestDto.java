package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tmanager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerRequestDto {

    private Long xindex;

    private Long sitenum;

    private Long groupnum;

    private String id;

    private String name;

    private Tmanager tmanager;
}
