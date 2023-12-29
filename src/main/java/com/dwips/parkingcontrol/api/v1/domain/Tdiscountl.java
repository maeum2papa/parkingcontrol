package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tdiscountl(할인테이블)
 *

 *
 * 할인타입	시간	0
 * 	금액	1
 * 	퍼센트	2
 * 	고정	3
 *
 * 	할인키가 90이 넘을 경우 복수할인으로 value 값을 99XXXXXX
 * 	99 다음 2자리씩 할인키 값 최대 3개까지
 *
 * 중복확인 sitenum+groupnum+key  이 하나만 존재해야 함 같은항목이 올경우 무조건 업데이트 하기
 */
@Data
@Entity
@Builder
public class Tdiscountl {

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

    //할인키
    @Column(columnDefinition = "INT")
    private Long key;

    //할인타입(시간,금액,퍼센트,고정)
    @Column(columnDefinition = "INT")
    private Long type;

    //할인값
    @Column(columnDefinition = "INT")
    private Long value;

    //최대할인
    @Column(columnDefinition = "INT")
    private Long maxcountt;

    //등록일
    private LocalDateTime regdate;

    //수정일
    private LocalDateTime moddate;

    //관리자ID
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //할인권타이틀
    @Column(columnDefinition = "VARCHAR(11)")
    private String title;

}
