package com.umc.mteam.domain;

import lombok.*;

import javax.persistence.*;

import com.umc.mteam.domain.enums.Status;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookCount;

    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    @Enumerated(value = EnumType.STRING)
    private Status status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
