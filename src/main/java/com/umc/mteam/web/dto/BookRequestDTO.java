package com.umc.mteam.web.dto;

import java.time.LocalDate;

import com.umc.mteam.domain.enums.BookStatus;

import lombok.Getter;

public class BookRequestDTO {
    @Getter
    public static class EnRollDTO {
        private String bookName;
        private String imageUrl;
        private String bookPublisher;
        private String author;
        private String description;
        private Long page;
        private Integer likes;
        private BookStatus status;
        private String expireAt;
        private String startAt;
    }
}
