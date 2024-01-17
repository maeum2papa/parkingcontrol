package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Taccountinfo {

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

    //아이디
    @Column(columnDefinition = "VARCHAR(30)")
    private String id;

    //할인키
    @Column(columnDefinition = "INT")
    private Long diskey;

    //현재카우트
    @Column(columnDefinition = "VARCHAR(30)")
    private String nowcount;

    //최대카운트
    @Column(columnDefinition = "VARCHAR(20)")
    private String maxcount;

    //등록일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //개시일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate moddate;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String mid;

}
