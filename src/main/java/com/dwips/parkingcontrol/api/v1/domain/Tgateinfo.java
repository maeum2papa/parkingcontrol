package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tgateinfo {

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
    @Column(columnDefinition = "VARCHAR(30)")
    private String devicenum;

    //입/출구분
    @Column(columnDefinition = "VARCHAR(10)")
    private String iotype;

    //아이피
    @Column(columnDefinition = "VARCHAR(30)")
    private String gateip;


    //
    @Column(columnDefinition = "VARCHAR(30)")
    private String command;


}