package com.umc.mteam.web.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.umc.mteam.domain.enums.BookStatus;

import lombok.Getter;
import lombok.Setter;

public class BookRequestDTO {
    @Getter
    @Setter
    public static class EnRollDTO {
        private String bookName;
        private String imageUrl;
        private String bookPublisher;
        private String author;
        private String description;
        private Long page;
        private Integer like;
        private BookStatus status;
        private String expireAt;
        private String startAt;
        private MultipartFile image;
    }
}
