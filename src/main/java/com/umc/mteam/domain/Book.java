package com.umc.mteam.domain;

import lombok.*;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.umc.mteam.domain.common.BaseEntity;
import com.umc.mteam.domain.enums.BookStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bookName;

    private String image_url;

    @Column(nullable = false)
    private String book_publisher;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, columnDefinition = "VARCHAR(200) DEFAULT '내용 없음'")
    private String description;

    @Column(nullable = false)
    private Long page;

    private String review;

    private Integer likes;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'SCHEDULED'")
    private BookStatus status;

    @Column(nullable = false)
    // private LocalDate start_at;
    private String start_at;
    
    @Column(nullable = false)
    // private LocalDate expire_at;
    private String expire_at;
}
