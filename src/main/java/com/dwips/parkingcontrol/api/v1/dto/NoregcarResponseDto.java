package com.dwips.parkingcontrol.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_EMPTY)
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoregcarResponseDto {

    private Integer result;
}
