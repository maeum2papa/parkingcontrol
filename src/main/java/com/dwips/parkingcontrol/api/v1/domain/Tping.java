package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tping (장비얼라이브)
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long xindex;

    //사이트번호(대분류)
    @Column(columnDefinition = "INT")
    private Long sitenum;

    //장치소속그룹(중분류)
    @Column(columnDefinition = "INT")
    private Long groupnum;

    //일반권입차
    @Column(columnDefinition = "INT")
    private Long xparkin;

    //일반권출차
    @Column(columnDefinition = "INT")
    private Long xparkinfo;

    //정기권입차
    @Column(columnDefinition = "INT")
    private Long xperiodin;

    //정기권출차
    @Column(columnDefinition = "INT")
    private Long xperiodinout;

    //신용카드결제
    @Column(columnDefinition = "INT")
    private Long xcredit;

    //일반권결제
    @Column(columnDefinition = "INT")
    private Long xparkcal;

}
