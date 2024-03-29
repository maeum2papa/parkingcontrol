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
 * tdevicealarm(장치알람)
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tdevicealarm {

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
    @Column(columnDefinition = "VARCHAR(30)")
    private String devicename;

    //장치등록참조
    @Column(columnDefinition = "INT")
    private Long devicetype;

    //접속 IP
    @Column(columnDefinition = "VARCHAR(40)")
    private String ip;

    //알람종류
    @Column(columnDefinition = "VARCHAR(10)")
    private String alarmkind;

    //발생시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime alarmtime;

    //복구시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime repairtime;

    //알람종류
    @Column(columnDefinition = "VARCHAR(100)")
    private String alarmmsg;

    //복구메세지
    @Column(columnDefinition = "VARCHAR(100)")
    private String repairmsg;

    //관리자코드
    @Column(columnDefinition = "VARCHAR(20)")
    private String managerid;

    //관리자이름
    @Column(columnDefinition = "VARCHAR(40)")
    private String managername;
}
