package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

/**
 * tparkingnum(차량대수)
 *
 * 	입차 및 출차시에 자동 카운팅후 결과 전송하기
 */
@Data
@Entity
@Builder
public class Tparkingnum {

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

    //일반차량입차
    @Column(columnDefinition = "INT")
    private Long inilbancnt;

    //일반차량출차
    @Column(columnDefinition = "INT")
    private Long outilbacnt;

    //등록차량입차
    @Column(columnDefinition = "INT")
    private Long inregcnt;

    //등록차량출차
    @Column(columnDefinition = "INT")
    private Long outregcnt;

    //일반차량만차대수
    @Column(columnDefinition = "INT")
    private Long ilbanfullnum;

    //등록차량만차대수
    @Column(columnDefinition = "INT")
    private Long regfullnum;

}
