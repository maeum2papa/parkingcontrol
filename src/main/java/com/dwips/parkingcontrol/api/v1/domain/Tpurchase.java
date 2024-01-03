package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tpurchase (구매내역)
 *
 *  소속코드	원격으로 할인시 필수입력 사항 추후 업체별로 할인내역으로 요금징수
 */
@Data
@Entity
@Builder
public class Tpurchase {

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

    //차량번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String carnum;

    //정기권종류(periodmember JOIN)
    @Column(columnDefinition = "INT")
    private Long periodtype;

    //주차장명
    @Column(columnDefinition = "VARCHAR(50)")
    private String parkname;

    //주차장고유코드
    @Column(columnDefinition = "INT")
    private Long parkcode;

    //주차장결제일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate parkpaydate;

    //결제상태
    @Column(columnDefinition = "VARCHAR(11)")
    private String payment;

    //주차요금
    @Column(columnDefinition = "INT")
    private Long parkprice;

    //결제일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paydate;

}
