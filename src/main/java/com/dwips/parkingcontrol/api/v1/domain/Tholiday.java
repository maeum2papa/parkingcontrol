package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tholiday (휴일설정)
 */
@Data
@Entity
@Builder
public class Tholiday {
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

    //휴일일자
    private LocalDate holiday;

    //휴일명칭
    @Column(columnDefinition = "VARCHAR(30)")
    private String msg;

    //등록일자
    private LocalDateTime regdate;

    //수정일자
    private LocalDateTime moddate;

}
