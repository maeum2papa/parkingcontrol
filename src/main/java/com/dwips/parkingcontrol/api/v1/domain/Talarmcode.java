package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * talarmcode(알람코드)
 */
@Data
@Entity
@Builder
public class Talarmcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long xindex;

    //장치종류
    @Column(columnDefinition = "INT")
    private Long devicetype;

    //에러코드
    @Column(columnDefinition = "INT")
    private Long errcode;

    //에러내용
    @Column(columnDefinition = "VARCHAR(40)")
    private String errname;

    //에러등급
    @Column(columnDefinition = "INT")
    private Long errgrade;

    //등록일
    private LocalDateTime regdate;

    //수정일
    private LocalDateTime moddate;

}
