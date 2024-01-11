package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 주차장구획정보
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

}