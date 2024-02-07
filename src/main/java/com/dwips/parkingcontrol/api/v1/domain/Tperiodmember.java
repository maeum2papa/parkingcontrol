package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tperiodmember (등록차량관리)
 *
 * parkarea	ABCDEFG	1111111
 *             1:가능 0:불능
 *     parkvalidday	월화수목금토일	1111111
 *             1:가능 0:불능
 *     parklevel	0:일반, 1:홀짝, 2:10부제, 3:요일제
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tperiodmember {

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

    //등록기기
    @Column(columnDefinition = "INT")
    private Long devicenum;

    //정기권번호
    @Column(columnDefinition = "INT")
    private Long cardno;

    //마크코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String serialno;

    //정기권종류
    @Column(columnDefinition = "INT")
    private Long periodtype;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //차량종류
    @Column(columnDefinition = "VARCHAR(30)")
    private String cartype;

    //이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //전화번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String tel;

    //그룹코드(정기권 그룹번호)
    @Column(columnDefinition = "INT")
    private Long groupcode;

    //소속1(tcompany 참조)
    @Column(columnDefinition = "VARCHAR(30)")
    private String company;

    //소속2(tdepartment 참조)
    @Column(columnDefinition = "VARCHAR(30)")
    private String depart;

    //주소
    @Column(columnDefinition = "VARCHAR(100)")
    private String addr;

    //주차시간(전일,오전,오후,시간)
    @Column(columnDefinition = "INT")
    private Long parktype;

    //등록일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //개시일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startdate;

    //종료일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate enddate;

    //주차가능코드(tperiodparktime)
    @Column(columnDefinition = "INT")
    private Long parktimecode;

    //주차가능시간(tperiodparktime)
    @Column(columnDefinition = "VARCHAR(20)")
    private String parktimetime;

    //주차요금
    @Column(columnDefinition = "INT")
    private Long parkprice;

    //주차가능구간(주차영역할당)
    @Column(columnDefinition = "VARCHAR(10)")
    private String parkarea;

    //주차레벨(부제/요일제/기타)
    @Column(columnDefinition = "INT")
    private Long parklevel;

    //주차가능요일(주차가능요일)
    @Column(columnDefinition = "VARCHAR(10)")
    private String parkvalidday;

    //주차가능유무
    @Column(columnDefinition = "INT")
    private Long useflag;

    //서비스일
    @Column(columnDefinition = "INT")
    private Long serviceday;

    //할인적용키값(tdiscount 참조)
    @Column(columnDefinition = "INT")
    private Long diskey;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String mname;

    //결제방법
    @Column(columnDefinition = "INT")
    private Long paytype;

    //입출구분
    @Column(columnDefinition = "INT")
    private Long outflag;

    //할인키(tdiscountinfo 의 코드)
    @Column(columnDefinition = "INT")
    private Long infodiskey;

    //사용여부
    @Column(columnDefinition = "VARCHAR(1)")
    private String useyn;
}
