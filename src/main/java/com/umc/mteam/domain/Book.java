package com.umc.mteam.domain;

import lombok.*;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private String image_url;

    private String book_publisher;

    private String author;

    private String description;

    private Long page;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookGoal> bookGoalList;
}
