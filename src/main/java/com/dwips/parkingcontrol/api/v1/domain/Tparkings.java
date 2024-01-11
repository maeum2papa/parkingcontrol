package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 주차장정보
 *
 * 주차장구획정보, 구획내주차면정보 와 연계됨
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tparkings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long xindex;

    //사이트번호 (대분류)
    @Column(columnDefinition = "INT")
    private Long sitenum;

    //장치소속그룹 (중분류)
    @Column(columnDefinition = "INT")
    private Long groupnum;

    //주차장이름
    @Column(columnDefinition = "varchar(45)")
    private String parkname;

    //주차장종류 (노상, 노외)
    @Column(columnDefinition = "varchar(2)")
    private String parktype;

    //주소
    @Column(columnDefinition = "varchar(100)")
    private String addr;

    //전화번호
    @Column(columnDefinition = "varchar(30)")
    private String tel;

    //대표자
    @Column(columnDefinition = "varchar(30)")
    private String boss;

    //원격제어장지IP
    @Column(columnDefinition = "varchar(40)")
    private String ip;

    //접속포트번호
    @Column(columnDefinition = "INT")
    private Long port;

    //아이디
    @Column(columnDefinition = "varchar(20)")
    private String id;

    //패스워드
    @Column(columnDefinition = "varchar(128)")
    private String password;

    //등록일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

    //사용여부
    @Column(columnDefinition = "char(1)")
    private String useyn;

    //오픈시간
    @Column(columnDefinition = "varchar(11)")
    private String opentime;

    //마감시간
    @Column(columnDefinition = "varchar(11)")
    private String closetime;

    //구획면수 (노상인경우 구획 개수)
    @Column(columnDefinition = "INT")
    private String unitarea;

    //총주차면수 (주차장 총 주차면 수)
    @Column(columnDefinition = "INT")
    private String unitparking;
}