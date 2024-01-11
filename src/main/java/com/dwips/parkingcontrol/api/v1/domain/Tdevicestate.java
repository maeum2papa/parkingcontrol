package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

/**
 * tdevicestate(장치상태)
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tdevicestate {

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

    //장치번호
    @Column(columnDefinition = "INT")
    private Long devicenum;

    //장치이름
    @Column(columnDefinition = "VARCHAR(50)")
    private String devicename;

    //장치등록참조
    @Column(columnDefinition = "INT")
    private Long devicetype;

    //접속
    @Column(columnDefinition = "INT")
    private Long ip;

    //잔액
    @Column(columnDefinition = "INT")
    private Long restmoney;

    //수입
    @Column(columnDefinition = "INT")
    private Long income;

    //최조접속시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime connecttime;

    //마지막접속시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lasttime;

    //잔액 50000원
    @Column(columnDefinition = "INT")
    private Long restmoney0;

    //잔액 10000원
    @Column(columnDefinition = "INT")
    private Long restmoney1;

    //잔액 5000원
    @Column(columnDefinition = "INT")
    private Long restmoney2;

    //잔액 1000원
    @Column(columnDefinition = "INT")
    private Long restmoney3;

    //잔액 500원
    @Column(columnDefinition = "INT")
    private Long restmoney4;

    //잔액 100원
    @Column(columnDefinition = "INT")
    private Long restmoney5;

    //에러코드
    @Column(columnDefinition = "INT")
    private Long errcode;

}
