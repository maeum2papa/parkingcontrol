package com.dwips.parkingcontrol.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateRequestDto {

    @JsonProperty("IOTYPE")
    private String IOTYPE;

    private Long sitenum;

    private Long groupnum;

    private Long devicenum;

    //  차량번호(4자리) 또는 차량번호전체
    private String carnum;
}
