package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tmanager(담당자등록)
 *
 *
 * grade	1	근무자
 * 	2	메니저권한1
 * 	3	메니저권한2
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tmanager {

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

    //관리자ID
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자패스워드
    @Column(columnDefinition = "VARCHAR(200)")
    private String mpw;

    //근무자권한
    @Column(columnDefinition = "INT")
    private Long grade;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    //관리자전화번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String tel;

    //근무자소속
    @Column(columnDefinition = "VARCHAR(40)")
    private String dept;

    //사용유무
    @Column(columnDefinition = "VARCHAR(1)")
    private String useyn;

    //등록일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

}
