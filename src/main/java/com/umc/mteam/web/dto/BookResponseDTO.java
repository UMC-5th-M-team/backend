package com.umc.mteam.web.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

public class BookResponseDTO {
    @Getter
    @Builder
    public static class EnrollResultDTO {
        private Long book_id;
        private LocalDateTime created_at;
    }
}
