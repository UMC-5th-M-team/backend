package com.umc.mteam.domain;

import lombok.*;

import javax.persistence.*;

import com.umc.mteam.domain.enums.BookStatus;
import com.umc.mteam.domain.enums.Status;

import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startAt;

    private LocalDateTime expireAt;

    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'SCHEDULED'")
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
