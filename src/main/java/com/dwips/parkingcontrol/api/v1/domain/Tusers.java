package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tnotices (고객정보)
 */
@Data
@Entity
@Builder
public class Tusers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long xindex;

    //휴대폰번호
    @Column(columnDefinition = "VARCHAR(15)")
    private String tel1;

    //사용자
    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String cranum1;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //푸시를 위한 디바이스 키 정보
    @Column(columnDefinition = "TEXT")
    private String devicekey;

    //개인정보제공동의
    @Column(columnDefinition = "VARCHAR(1)")
    private String flsg;

    //최근접속아이피
    @Column(columnDefinition = "VARCHAR(30)")
    private String ip;

    //최근접속일시
    private LocalDateTime logindate;

    //등록일
    private LocalDateTime rewgdate;

    //수정일
    private LocalDateTime moddate;

    //탈퇴여부
    @Column(columnDefinition = "VARCHAR(1)")
    private String useyn;

    //감면내용
    @Column(columnDefinition = "VARCHAR(30)")
    private String disList;

    //위치정보 동의
    @Column(columnDefinition = "VARCHAR(11)")
    private String gpsyn;

    //문자수신 동의
    @Column(columnDefinition = "VARCHAR(11)")
    private String smsyn;

    //푸시수신 동의
    @Column(columnDefinition = "VARCHAR(11)")
    private String pushyn;

    //개인정보 동의
    @Column(columnDefinition = "VARCHAR(11)")
    private String infoyn;

    //이용약관 동의
    @Column(columnDefinition = "VARCHAR(11)")
    private String agreeyn;
}
