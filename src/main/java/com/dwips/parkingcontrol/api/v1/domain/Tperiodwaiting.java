package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tperiodwaiting (예약차량)
 */
@Data
@Entity
@Builder
public class Tperiodwaiting {

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

    //정기권종류
    @Column(columnDefinition = "INT")
    private Long periodtype;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //차종
    @Column(columnDefinition = "VARCHAR(30)")
    private String cartype;

    //이름
    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    //전화번호
    @Column(columnDefinition = "VARCHAR(20)")
    private String tel;

    //대기날자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime waitingdate;

    //대기순번
    @Column(columnDefinition = "VARCHAR(30)")
    private String waitingcount;

    //예약구역
    @Column(columnDefinition = "VARCHAR(30)")
    private String watingparkarea;

    //주차장명
    @Column(columnDefinition = "VARCHAR(50)")
    private String parkname;

    //주차장코드
    @Column(columnDefinition = "INT")
    private Long parkcode;

    //등록날짜
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정날자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

    //배정상태
    @Column(columnDefinition = "VARCHAR(20)")
    private String ticketstatus;

}
