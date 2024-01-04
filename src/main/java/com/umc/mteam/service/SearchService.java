package com.umc.mteam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umc.mteam.converter.SearchConverter;
import com.umc.mteam.web.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {

    private final String CLIENT_ID = "NHwFcWGSqe2gFdOxPUis";
    private final String CLIENT_SECRET = "aHGFEiK3Qz";

    private final String OpenNaverBookUrl = "https://openapi.naver.com/v1/search/book.json?query=";


    public SearchDTO.BookListDTO searchBook(String bookName) {

        String url = OpenNaverBookUrl + bookName;
//        final HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Naver-Client-Id", CLIENT_ID);
//        headers.set;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        SearchDTO.BookListDTO bookList = SearchConverter.jsonToBookListDTO(responseEntity.getBody());
        // JSON 형식의 응답 문자열 반환
        return bookList;
    }

}
