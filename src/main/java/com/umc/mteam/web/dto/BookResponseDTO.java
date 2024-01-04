package com.umc.mteam.web.dto;

import java.time.LocalDateTime;

import com.umc.mteam.domain.enums.BookStatus;


import lombok.Builder;
import lombok.Getter;

public class BookResponseDTO {
    @Getter
    @Builder
    public static class EnrollResultDTO {
        private Long book_id;
        private LocalDateTime created_at;
    }

    // 전체 책 리스트 조회할 때 리스트의 각 요소 DTO
    @Getter
    @Builder
    public static class BookElementDTO {
        private String title;
        private String author;
        private String description;
        private String expire_at;
        private BookStatus status;
    }
}
