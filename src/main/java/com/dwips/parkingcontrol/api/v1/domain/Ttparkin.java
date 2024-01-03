package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tparkin (일반차량 입차)
 *
 *
 * cartype	0	소형
 * 	1	대형
 * 	2	기타
 *
 * parktype	0	하루
 * 	1	정액
 * 	2	기간
 *
 * outflag	 'I'(73)	입차
 * 	 'O'(79)	출차
 * 	 'X'(88)	정산완료
 */
@Data
@Entity
@Builder
public class Ttparkin {

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

    //MR 실제 데이터 (MUL	고유코드생성)
    @Column(columnDefinition = "VARCHAR(30)")
    private String ticketdata;

    //입차영상후면
    @Column(columnDefinition = "VARCHAR(100)")
    private String inbackimage;

    //입차영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String inimage;

    //차번(PRI)
    @Column(columnDefinition = "VARCHAR(30)")
    private String carnum;

    //주차한곳(유도관제)
    @Column(columnDefinition = "VARCHAR(20)")
    private String parkonplace;

    //관리자아이디
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String mname;

    //차량구분 (소형/중형/대형)
    @Column(columnDefinition = "INT")
    private Long cartype;

    //주차차량구분 (하루/정액/기간)
    @Column(columnDefinition = "INT")
    private Long parktype;

    //입차기기번호
    @Column(columnDefinition = "INT")
    private Long indevicenum;

    //정산여부(I:입차 O:출차)
    @Column(columnDefinition = "INT")
    private Long outflag;

    //입차날자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime indatetime;

}
