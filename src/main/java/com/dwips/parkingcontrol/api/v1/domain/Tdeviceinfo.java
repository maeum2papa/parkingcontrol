package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tdeviceinfo(장치등록)
 *
 *
 * 	장치종류	유인요금정산기	1
 * 		무인요금정산기	2
 * 		차량번호인식기	3
 * 		티켓발행기	4
 * 		PDA	5
 * 		기타장치	0
 *
 */
@Data
@Entity
@Builder
public class Tdeviceinfo {

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

    //장치번호
    @Column(columnDefinition = "VARCHAR(50)")
    private String devicename;

    //장치종류
    @Column(columnDefinition = "INT")
    private Long devicetype;

    //ip
    @Column(columnDefinition = "VARCHAR(40)")
    private String ip;

    //등록일
    private LocalDateTime regdate;

    //수정일
    private LocalDateTime moddate;

    //기타
    @Column(columnDefinition = "VARCHAR(100)")
    private String note;

    //사용유무
    @Column(columnDefinition = "VARCHAR(1)")
    private String useyn;

}
