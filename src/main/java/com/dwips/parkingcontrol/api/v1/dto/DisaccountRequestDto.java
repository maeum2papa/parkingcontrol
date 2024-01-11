package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisaccountRequestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private String id;

    private String name;

    private Tdisaccount tdisaccount;
}
