package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


/**
 * tdisaccount (할인계정)
 *
 * 원격할인 로그인 정보
 */
@Data
@Builder
@Entity
public class Tdisaccount {

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

    //패스
    @Column(columnDefinition = "VARCHAR(40)")
    private String pass;

    //이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //전화번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String tel;

    //소속코드
    @Column(columnDefinition = "INT")
    private Long deptcode;

    //레벨
    @Column(columnDefinition = "INT")
    private Long grade;

    //등록일자
    private LocalDate regdate;

    //수정일자
    private LocalDate moddate;

}
