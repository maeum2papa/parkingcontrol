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
 * tperiodparktime (정기권주차시간)
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tperiodparktime {

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

    //타임코드
    @Column(columnDefinition = "INT")
    private Long code;

    //설명
    @Column(columnDefinition = "VARCHAR(30)")
    private String description;

    //시작시간
    @Column(columnDefinition = "INT")
    private Long starthour;

    //시작분
    @Column(columnDefinition = "INT")
    private Long startmin;

    //종료시간
    @Column(columnDefinition = "INT")
    private Long endhour;

    //종료분
    @Column(columnDefinition = "INT")
    private Long endmin;

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
