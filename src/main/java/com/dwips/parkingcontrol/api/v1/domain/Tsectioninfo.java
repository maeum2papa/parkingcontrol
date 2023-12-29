package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 주차장구획정보
 */
@Data
@Entity
@Builder
public class Tsectioninfo {

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

    //구획코드(예) A01)
    @Column(columnDefinition = "VARCHAR(4)")
    private String seccode;

    //구획설명
    @Column(columnDefinition = "VARCHAR(50)")
    private String secname;

    //여유면수(빈 주차면수)
    @Column(columnDefinition = "INT")
    private Long secspace;

    //총주차면수
    @Column(columnDefinition = "INT")
    private Long secfull;

    //등록일
    private LocalDateTime regdate;

    //수정일
    private LocalDateTime moddate;

}