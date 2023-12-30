package com.dwips.parkingcontrol.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarinRequestDto {

    @JsonProperty("IOTYPE")
    private String IOTYPE;

    private Long sitenum;

    private Long groupnum;

    private Long devicenum;

    private String carnum;

    private String indatetime;

    private String image;

    private Long cartype;

    private Long parktype;

    private Long option;

}
