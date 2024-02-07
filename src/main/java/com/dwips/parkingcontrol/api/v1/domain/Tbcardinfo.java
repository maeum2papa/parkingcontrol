package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tbcardinfo (신용카드 결제 내역)
 *
 *  결제종류	일반권	0
 *     정기권	1
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tbcardinfo {

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

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //단말기ID
    @Column(columnDefinition = "VARCHAR(20)")
    private String termid;

    //POS ID
    @Column(columnDefinition = "VARCHAR(20)")
    private String posid;

    //처리결과
    @Column(columnDefinition = "VARCHAR(10)")
    private String rescode;

    //처리결과코드
    @Column(columnDefinition = "VARCHAR(30)")
    private String dealnum;

    //처리날자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 00:00:00")
    private LocalDateTime dealdate;

    //처리시간
    @Column(columnDefinition = "VARCHAR(10)")
    private String dealtime;

    //카드종류
    @Column(columnDefinition = "VARCHAR(30)")
    private String cardname;

    //카드번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String cardid;

    //카드발행기간
    @Column(columnDefinition = "VARCHAR(20)")
    private String branchnum;

    //승인번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String acceptnum;

    //영수번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String receiptnum;

    //결제처리종류
    @Column(columnDefinition = "INT")
    private Long accepttype;

    //요금
    @Column(columnDefinition = "INT")
    private Long money;

    //주차시간
    @Column(columnDefinition = "INT")
    private Long parktime;

    //입차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime indatetime;

    //출차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime outdatetime;

    //결제취소금액
    @Column(columnDefinition = "INT")
    private Long cancelmoney;

    //취소시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime canceltime;

    //외래키(tparkin xindex 및 tperiodaccount xindex)
    @Column(columnDefinition = "BIGINT")
    private Long pindex;

    //결제종류(일반권,정기권)
    @Column(columnDefinition = "INT")
    private Long credittype;

    //기타필요정보
    @Column(columnDefinition = "VARCHAR(45)")
    private String msg;

    //전화번호
    @Column(columnDefinition = "VARCHAR(50)")
    private String tel;


}
