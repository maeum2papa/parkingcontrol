package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tbangmun (방문차량등록)
 *
 * 예약종류	일반예약	0
 *     긴급차량	1
 *     외상차량	2
 */
@Data
@Entity
@Builder
public class Tbangmun {

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

    //임시번호
    @Column(columnDefinition = "INT")
    private Long cardid;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //전화번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String tel;

    //방문목적
    @Column(columnDefinition = "VARCHAR(30)")
    private String visitobject;

    //방문장소
    @Column(columnDefinition = "VARCHAR(30)")
    private String visitplace;

    //등록일자
    private LocalDateTime regdate;

    //개시일자
    private LocalDate starddate;

    //종료일자
    private LocalDate enddate;

    //수정일자
    private LocalDateTime moddate;

    //할인키
    @Column(columnDefinition = "INT")
    private Long diskey;

    //외래키(tparkin xindex)
    @Column(columnDefinition = "INT")
    private Long pindex;

    //예약종류
    @Column(columnDefinition = "INT")
    private Long reservedtype;


}
