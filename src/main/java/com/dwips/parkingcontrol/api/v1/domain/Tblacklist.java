package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tblacklist (블랙차량리스트)
 */
@Data
@Entity
@Builder
public class Tblacklist {

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

    //시작일자
    private LocalDate startdate;

    //종료일자
    private LocalDate enddate;

    //등록일자
    private LocalDateTime regdate;

    //수정일자
    private LocalDateTime moddate;

    //메세지
    @Column(columnDefinition = "VARCHAR(80)")
    private String msg;
}
