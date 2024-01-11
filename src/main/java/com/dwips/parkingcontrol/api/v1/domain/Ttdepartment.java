package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tdepartment (부서정보)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ttdepartment {

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

    //회사코드
    @Column(columnDefinition = "INT")
    private Long ccode;

    //소속회사
    @Column(columnDefinition = "VARCHAR(30)")
    private String cname;

    //부서코드
    @Column(columnDefinition = "INT")
    private Long code;

    //부서이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;


    //전화번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String tel;


    //팩스번호
    @Column(columnDefinition = "VARCHAR(30)")
    private String fax;


    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String mname;


    //등록일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

    //기타
    @Column(columnDefinition = "VARCHAR(100)")
    private String note;
}
