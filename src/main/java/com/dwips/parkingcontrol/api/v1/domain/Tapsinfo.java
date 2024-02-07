package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tapsinfo {

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


    //무인IP
    @Column(columnDefinition = "VARCHAR(30)")
    private String ip;

    //장치번호
    @Column(columnDefinition = "VARCHAR(10)")
    private String devicenum;

    //pindex(tparkinfo 의 xindex)
    @Column(columnDefinition = "INT")
    private Long pindex;


    //입차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime indatetime;


    //정산시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime caldatetime;

    //출차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime outdatetime;


    //주차요금
    @Column(columnDefinition = "INT")
    private Long totalfee;

    //할인요금
    @Column(columnDefinition = "INT")
    private Long disfee;

    //정산요금
    @Column(columnDefinition = "INT")
    private Long calfee;

    //할인시간
    @Column(columnDefinition = "INT")
    private Long distime;

    //상태
    @Column(columnDefinition = "INT")
    private Long status;
}