package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tparkinfo (일반차량출차정보)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tparkinfo {

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

    //차종(소형/중형/대형)
    @Column(columnDefinition = "INT")
    private Long cartype;

    //주차종류(일반/분실/판불/무효)
    @Column(columnDefinition = "INT")
    private Long parktype;

    //입차장치
    @Column(columnDefinition = "INT")
    private Long indevicenum;

    //출차장치
    @Column(columnDefinition = "INT")
    private Long outdevicenum;

    //MS 실제 데이터(입차고유코드)
    @Column(columnDefinition = "VARCHAR(30)")
    private String ticketdata;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //입차날자
    private LocalDateTime indatetime;

    //출차날자
    private LocalDateTime outdatetime;

    //입차 영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String inimage;

    //출차 영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String outimage;

    //후면영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String backimage;

    //주차시간
    @Column(columnDefinition = "INT")
    private Long parktime;

    //수동/자동구분자 (수동/자동)
    @Column(columnDefinition = "INT")
    private Long manual;

    //주차요금
    @Column(columnDefinition = "INT")
    private Long parkfee;

    //할인요금
    @Column(columnDefinition = "INT")
    private Long discountfee;

    //할인시간
    @Column(columnDefinition = "INT")
    private Long discounttime;

    //카드타입(신용/교통/T머니)
    @Column(columnDefinition = "INT")
    private Long credittype;

    //카드번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String creditcardno;

    //승인번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String acceptno;

    //승인시간
    private LocalDateTime accepttime;

    //카드금액
    @Column(columnDefinition = "INT")
    private Long creditpay;

    //영주증번호
    @Column(columnDefinition = "INT")
    private Long receiptno;

    //OCS진료카드번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String ocscode;

    //OCS할인종류(시간/금액/할인/고정)
    @Column(columnDefinition = "INT")
    private Long ocstype;

    //OCS할인값
    @Column(columnDefinition = "INT")
    private Long ocsval;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(40)")
    private String mname;

    //복지카드영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String welfareimage;

    //담당마감(0 : 미 마감)
    @Column(columnDefinition = "INT")
    private Long manflag;


    //일마감(1 : 마감완료)
    @Column(columnDefinition = "INT")
    private Long dendflag;

    //전체마감
    @Column(columnDefinition = "INT")
    private Long tendflag;

    //일마감시간
    private LocalDateTime denddate;

    //입출구문(X:계산완료 O:출차)
    @Column(columnDefinition = "INT")
    private Long outflag;
}
