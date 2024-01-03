package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * twelfare (사전할인차량)
 *
 * weltype	장애인
 *     국가유공자
 *             다둥이
 *     경차
 *             승용차요일제
 *     저공해자동차
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Twelfare {

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

    //할인차량ID(복지카드번호)
    @Column(columnDefinition = "VARCHAR(32)")
    private String welfareid;

    //복지할인종류
    @Column(columnDefinition = "INT")
    private Long welfaretype;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //이름
    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    //전화번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String tel;

    //등록일자
    private LocalDateTime regdate;

    //개시일자
    private LocalDate starddate;

    //종료일자
    private LocalDate enddate;

    //할인키(tdiscountl(할인테이블))
    @Column(columnDefinition = "INT")
    private Long diskey;

    //관리자코드(등록 ID)
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;


}
