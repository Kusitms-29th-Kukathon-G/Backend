package com.kukathon.teamg.domain.sample.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Sample {

    @Id
    @Column(name = "sample_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    public static Sample createSample(String text) {
        return Sample.builder()
                .text(text)
                .build();
    }
}