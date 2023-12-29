package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 로그온정보
 *
 * logtype	0	로그오프
 * 	1	로그온
 *
 */
@Data
@Builder
@Entity
public class Tlogon {

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

    //장치주소
    @Column(columnDefinition = "INT")
    private Long devicenum;

    //장치이름
    @Column(columnDefinition = "VARCHAR(50)")
    private String devicename;

    //장치종류
    @Column(columnDefinition = "INT")
    private Long devicetype;

    //관리자ID
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자패스
    @Column(columnDefinition = "VARCHAR(128)")
    private String mpw;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String mname;

    //로그시간
    private LocalDateTime logdatetime;

    //로그종류
    @Column(columnDefinition = "INT")
    private Long logtype;
}
