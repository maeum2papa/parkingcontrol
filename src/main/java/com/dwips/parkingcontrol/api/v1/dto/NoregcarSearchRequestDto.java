package com.dwips.parkingcontrol.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoregcarSearchRequestDto {

    private Long sitenum;

    private Long groupnum;

    private String datefrom;

    private String dateto;
}
