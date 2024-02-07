package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Taccountinfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountinfoRquestDto {

    private Long sitenum;

    private Long groupnum;

    private Long xindex;

    private String id;

    private Long diseky;

    private Taccountinfo taccountinfo;
}
