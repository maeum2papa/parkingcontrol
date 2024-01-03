package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tperiodaccount (등록차량 수금내역)
 */
@Data
@Entity
@Builder
public class Tperiodaccount {

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

    //장치번호
    @Column(columnDefinition = "INT")
    private Long devicenum;

    //장치종류(유인/무인/PDA)
    @Column(columnDefinition = "INT")
    private Long devicetype;

    //정기권카드번호
    @Column(columnDefinition = "INT")
    private Long cardno;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //소속1(tcompany 참조)
    @Column(columnDefinition = "VARCHAR(30)")
    private String company;

    //소속2(tdepartment 참조)
    @Column(columnDefinition = "VARCHAR(30)")
    private String depart;

    //등록일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //개시일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startdate;

    //종료일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate enddate;

    //주차요금
    @Column(columnDefinition = "INT")
    private Long price;

    //징수방법(현금/신용카드)
    @Column(columnDefinition = "INT")
    private Long paytype;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String mname;

    //신용카드결제정보(tbcardinfo 참조)
    @Column(columnDefinition = "INT")
    private Long cdindex;
}
