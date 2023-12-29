package com.dwips.parkingcontrol.api.v1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tnotices (공지사항)
 */
@Data
@Entity
@Builder
public class Tnotices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long xindex;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime regdate;

    private LocalDateTime moddate;

    @Column(columnDefinition = "VARCHAR(200)")
    private String regmid;

    @Column(columnDefinition = "VARCHAR(200)")
    private String modmid;
}
