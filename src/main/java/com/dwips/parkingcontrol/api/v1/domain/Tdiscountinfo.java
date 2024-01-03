package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tdiscountinfo (일반차량할인내역)
 *
 * 소속코드	원격으로 할인시 필수입력 사항 추후 업체별로 할인내역으로 요금징수
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tdiscountinfo {

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

    //아이디
    @Column(columnDefinition = "VARCHAR(20)")
    private String id;

    //접속IP
    @Column(columnDefinition = "VARCHAR(30)")
    private String ip;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //소속코드(추후 입주사에 정산)
    @Column(columnDefinition = "INT")
    private Long deptcode;

    //할인코드
    @Column(columnDefinition = "INT")
    private Long discode;

    //할인종류
    @Column(columnDefinition = "INT")
    private Long distype;

    //할인값
    @Column(columnDefinition = "INT")
    private Long disvalue;

    //최대 할인
    @Column(columnDefinition = "INT")
    private Long maxcountt;

    //입차일자
    private LocalDateTime indatetime;

    //할인일자
    private LocalDateTime disdatetime;

    //외래키(tparkin xindex)
    @Column(columnDefinition = "BIGINT")
    private Long pindex;

}
