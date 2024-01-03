package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tparkfeex(주차요금정기권)
 *
 *
 * 차종은 A-E 스텝은 1 - 9 까지 주차시간이 설정된 경우 최대적용이 0인경우는 무한대
 *
 * 중복확인 sitenum+groupnum+code 이 하나만 존재해야 함 같은항목이 올경우 무조건 업데이트 하기
 *
 */
@Data
@Entity
@Builder
public class Tparkfeex {

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

    //요금코드
    @Column(columnDefinition = "INT")
    private Long code;

    //정기권 종류
    @Column(columnDefinition = "INT")
    private Long periodtype;

    //정기권 이름
    @Column(columnDefinition = "VARCHAR(50)")
    private String periodname;

    //등록일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //수정일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

    //등록아이디
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

    //수정아이디
    @Column(columnDefinition = "VARCHAR(20)")
    private String modmid;

    //비활성화여부
    @Column(columnDefinition = "VARCHAR(1)")
    private String useyn;

    //상품타입
    @Column(columnDefinition = "INT")
    private Long ptype;

    //상품명
    @Column(columnDefinition = "VARCHAR(30)")
    private String pname;

}
