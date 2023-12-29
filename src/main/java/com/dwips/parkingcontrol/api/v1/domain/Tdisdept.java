package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * tdisdept (할인업체)
 */
@Data
@Entity
@Builder
public class Tdisdept {

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

    //소속코드
    @Column(columnDefinition = "INT")
    private Long deptcode;

    //소속이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String deptname;

    //할인카운드
    @Column(columnDefinition = "INT")
    private Long discount;

    //차량별카운트
    @Column(columnDefinition = "INT")
    private Long carcount;

    //최대할인
    @Column(columnDefinition = "INT")
    private Long dismaxnum;

    //차량별최대할인
    @Column(columnDefinition = "INT")
    private Long carmaxnum;

    //등록일자
    private LocalDate regdate;

    //수정일자
    private LocalDate moddate;

}
