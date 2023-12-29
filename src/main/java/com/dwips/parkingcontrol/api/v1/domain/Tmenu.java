package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * tmenu (메뉴정보)
 */
@Data
@Entity
@Builder
public class Tmenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long xindex;

    @Column(columnDefinition = "VARCHAR(200)")
    private String parent;

    @Column(columnDefinition = "VARCHAR(200)")
    private String chlid;

    @Column(columnDefinition = "VARCHAR(200)")
    private String uri;

    private LocalDateTime regdate;

    private LocalDateTime moddate;
}
