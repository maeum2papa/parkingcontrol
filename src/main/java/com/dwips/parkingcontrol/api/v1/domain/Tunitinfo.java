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
 * 구획내주차면정보
 *
 * tunitparking 의 각 주차면의 상태 정보
 * unitstate
 * 	0: 빈자리
 * 	1 :예약
 * 	2:일반주차
 *
 * 거주자가 예약을 한 경우 주차장,구역 및 면 정보가 다 필요함
 *
 * sitenum+groupnum+seccode+unitcode 는 하나만 존재해야 함 같을 경우 업데이트
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tunitinfo {

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

    //주차면고유코드
    @Column(columnDefinition = "INT")
    private Long unitcode;

    //주차면설명
    @Column(columnDefinition = "VARCHAR(50)")
    private String unitname;

    //상태정보
    @Column(columnDefinition = "INT")
    private Long unitstate;

    //등록일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;
}
