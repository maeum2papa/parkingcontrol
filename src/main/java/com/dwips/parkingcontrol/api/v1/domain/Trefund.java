package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * trefund (환불내역)
 *
 * 소속코드	원격으로 할인시 필수입력 사항 추후 업체별로 할인내역으로 요금징수
 */
@Data
@Entity
@Builder
public class Trefund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long xindex;

    //사이트번호(대분류)
    @Column(columnDefinition = "INT")
    private Long sitenum;

    //장치소속그룹(중분류)
    @Column(columnDefinition = "INT")
    private Long groupnum;

    //아이디
    @Column(columnDefinition = "VARCHAR(20)")
    private String id;

    //이름
    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    //전화번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String tel;

    //주차장명
    @Column(columnDefinition = "VARCHAR(30)")
    private String parkname;

    //주차장고유코드
    @Column(columnDefinition = "INT")
    private Long parkcode;

    //차량번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String carnum;

    //결제일
    private LocalDateTime refunddate;

    //환불값
    @Column(columnDefinition = "INT")
    private Long refundvalue;

    //환불상태
    @Column(columnDefinition = "VARCHAR(1)")
    private String refundtype;


}
