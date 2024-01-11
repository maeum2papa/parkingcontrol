package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tparkcal (일반권 정산)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tparkcal {

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

    //입차고유코드
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //입차시간(소형/중형/대형)
    @Column(columnDefinition = "INT")
    private Long indatetime;

    //정산시간(일반/분실/판불/무효)
    @Column(columnDefinition = "INT")
    private Long outdatetime;

    //정산요금
    @Column(columnDefinition = "VARCHAR(30)")
    private String parkfee;

    //정산종류(현금/신용카드)
    @Column(columnDefinition = "INT")
    private Long parktype;

    //외래키(tparkin xindex)
    @Column(columnDefinition = "BIGINT")
    private Long pindex;

}
