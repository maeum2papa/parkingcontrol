package com.dwips.parkingcontrol.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * tmenu (메뉴정보)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime moddate;
}
