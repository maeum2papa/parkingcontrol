package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculateSearchResponseDto {

    private Integer result;

    private List<Tparkinfo> tparkinfo;

    private Map<Long,List<Tbcardinfo>> tbcardinfo;

    private Map<Long,List<Tdiscountinfo>> tdiscountinfo;

    private Map<Long,List<Twelfare>> welfare;

}
