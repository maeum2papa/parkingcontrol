package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tapsinfo {

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


    //무인IP
    @Column(columnDefinition = "VARCHAR(30)")
    private String ip;

    //장치번호
    @Column(columnDefinition = "VARCHAR(10)")
    private String devicenum;

}