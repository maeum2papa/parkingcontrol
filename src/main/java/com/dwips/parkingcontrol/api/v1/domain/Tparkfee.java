package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tparkfee(주차요금테이블)
 *
 * 차종은 A-E 스텝은 1 - 9 까지 주차시간이 설정된 경우 최대적용이 0인경우는 무한대
 *
 * 중복확인 sitenum+groupnum+carstep+weektype 이 하나만 존재해야 함 같은항목이 올경우 무조건 업데이트 하기
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tparkfee {

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

    //차종별스텝(A01)
    @Column(columnDefinition = "VARCHAR(4)")
    private String carstep;

    //주중/주말 (0:평일 1:주말)
    @Column(columnDefinition = "INT")
    private Long weektype;

    //주차시간
    @Column(columnDefinition = "INT")
    private Long parktime;

    //주차요금
    @Column(columnDefinition = "INT")
    private Long parkfee;

    //최대적용
    @Column(columnDefinition = "INT")
    private Long maxcount;

    //등록일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

    //등록아이디
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //상품명
    @Column(columnDefinition = "VARCHAR(30)")
    private String title;

}
