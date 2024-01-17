package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tparkconfig {

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

    //변수명
    @Column(columnDefinition = "VARCHAR(30)")
    private String cmdtype;

    //데이터
    @Column(columnDefinition = "VARCHAR(10)")
    private String value;

    //옵션
    @Column(name = "`option`" ,columnDefinition = "VARCHAR(10)")
    private String option;

    //등록일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    //등록일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;

    //msg
    @Column(columnDefinition = "VARCHAR(80)")
    private String msg;
}