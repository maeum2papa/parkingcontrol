package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tperiodinout(등록차량출차)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tperiodinout {

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

    //카드번호
    @Column(columnDefinition = "INT")
    private Long cardno;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //차량종류
    @Column(columnDefinition = "VARCHAR(30)")
    private String cartype;

    //이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //입차장치
    @Column(columnDefinition = "INT")
    private Long indevicenum;

    //입차날자
    private LocalDateTime indatetime;

    //입차 영상
    @Column(columnDefinition = "VARCHAR(30)")
    private String inimage;

    //출차장치
    @Column(columnDefinition = "INT")
    private Long outdevicenum;

    //출차날자
    private LocalDateTime outdatetime;

    //출차영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String outimage;

    //주차시간
    @Column(columnDefinition = "INT")
    private Long parktime;

    //종료일자
    private LocalDate enddate;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(30)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String mname;

    //입출구분
    @Column(columnDefinition = "INT")
    private Long outflag;

    //비고
    @Column(columnDefinition = "VARCHAR(45)")
    private String note;

}
