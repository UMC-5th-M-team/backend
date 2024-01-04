package com.umc.mteam.domain;

import lombok.*;

import javax.persistence.*;

import com.umc.mteam.domain.enums.Status;

import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String uid;

    private String password;

    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGoal> userGoalList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookGoal> bookGoalList;
}
