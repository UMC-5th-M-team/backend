package com.umc.mteam.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class SearchDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookListDTO{
//       private String title;
//        private String link;
//        private String description;
//        private String lastBuildDate;
//        private String total;
//        private String start;
//        private String display;
        private List<SearchDTO.SearchBookDTO> items;

//        Integer listSize;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchBookDTO{
        private String title;
        private String image;
        private String author;
        private String publisher;
        private String description;


    }
}
