package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculateResponseDto {

    private Integer result;

    private List<Tparkinfo> tparkinfo;

    private Tperiodmember tperiodmember;

    private List<List<Tbcardinfo>> tbcardinfo;

    private List<List<Tdiscountinfo>> tdiscountinfo;

    private List<List<Twelfare>> welfare;

}
