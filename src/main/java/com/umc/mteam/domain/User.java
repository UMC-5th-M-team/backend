package com.umc.mteam.domain;

import lombok.*;

import javax.persistence.*;

import com.umc.mteam.domain.common.BaseEntity;
import com.umc.mteam.domain.enums.Status;

import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String uid;

    private String password;

    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> bookList;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserGoal> userGoalList;
}
