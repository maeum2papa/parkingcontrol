package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tnorecognition (미인식차량정보)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tnorecognition {

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

    //장치주소
    @Column(columnDefinition = "INT")
    private Long devicenum;

    //장치이름
    @Column(columnDefinition = "VARCHAR(30)")
    private String devicename;

    //장치IP
    @Column(columnDefinition = "VARCHAR(30)")
    private String ip;

    //입차시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime iodatetime;

    //영상
    @Column(columnDefinition = "VARCHAR(100)")
    private String ioimage;
}
