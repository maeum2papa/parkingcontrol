package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tparkunpaied {

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

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //입차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime indatetime;

    //출차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime outdatetime;


    //주차요금
    @Column(columnDefinition = "INT")
    private Long parkfee;

    //
    @Column(columnDefinition = "BIGINT")
    private Long pindex;

}
