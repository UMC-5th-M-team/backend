package com.umc.mteam.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umc.mteam.web.dto.SearchDTO;

public class SearchConverter {

    public static SearchDTO.BookListDTO jsonToBookListDTO(String json){
        ObjectMapper objectMapper = new ObjectMapper();

        SearchDTO.BookListDTO bookList = null;

        try {
            bookList = objectMapper.readValue(json, SearchDTO.BookListDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }


}
