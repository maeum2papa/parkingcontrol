package com.dwips.parkingcontrol.api.v1.dto;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BcardinfoResponseDto {

    private Integer result;

    private List<Tbcardinfo> tbcardinfo;
}
