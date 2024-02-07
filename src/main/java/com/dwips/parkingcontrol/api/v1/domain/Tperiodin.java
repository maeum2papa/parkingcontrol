package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tperiodin(등록차량입차)
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tperiodin {

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

    //카드번호
    @Column(columnDefinition = "INT")
    private Long cardno;

    //차량번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //차량종류
    @Column(columnDefinition = "VARCHAR(30)")
    private String cartype;

    //사용자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //입차장치
    @Column(columnDefinition = "INT")
    private Long indevicenum;

    //입차날자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime indatetime;

    //입차영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String inimage;

    //종료기간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate enddate;

    //출차완료(I:입차 O:출차)
    @Column(columnDefinition = "INT")
    private Long outflag;

    //주차한곳(유도관제)
    @Column(columnDefinition = "VARCHAR(20)")
    private String parkonplace;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(20)")
    private String mname;
}
