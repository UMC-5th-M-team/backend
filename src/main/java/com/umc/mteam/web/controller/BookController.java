package com.umc.mteam.web.controller;

// import org.springframework.stereotype.Controller;
import com.umc.mteam.service.SearchService;
import com.umc.mteam.web.dto.SearchDTO;
import org.springframework.web.bind.annotation.*;

import com.umc.mteam.ApiPayload.ApiResponse;
import com.umc.mteam.service.BookService;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;
import com.umc.mteam.web.dto.BookResponseDTO.BookElementDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/book/")
public class BookController {
    private final BookService bookService;

    private final SearchService searchService;

    @GetMapping("/home/{bookName}")
    public ApiResponse<SearchDTO.BookListDTO> searchBook(@PathVariable(name = "bookName") String bookName) {

        SearchDTO.BookListDTO bookList = searchService.searchBook(bookName);


        return ApiResponse.onSuccess(bookList);
    }
    @PostMapping("/home")
    public ApiResponse<BookResponseDTO.EnrollResultDTO> enrollBook(
        @RequestBody BookRequestDTO.EnRollDTO enRollDTO, @RequestParam("user_id") Long userId
        ) {
            BookResponseDTO.EnrollResultDTO resultDTO = bookService.enrollBook(enRollDTO);
            return ApiResponse.onSuccess(resultDTO);
    }


    @GetMapping("/")
    public ApiResponse<List<BookResponseDTO.BookElementDTO>> getBookList(@RequestParam("user_id") Long userId) {
        List<BookResponseDTO.BookElementDTO> resultDTO = bookService.getBooksByUserId(userId);
        return ApiResponse.onSuccess(resultDTO);
    }


    @GetMapping("/random")
    public ApiResponse<BookResponseDTO.BookElementDTO> getRandomBook(@RequestParam("user_id") Long userId) {
        BookResponseDTO.BookElementDTO randomBook = bookService.getRandomBookByUserId(userId);
        if(randomBook == null) return ApiResponse.onFailure("4004", "사용자의 책 목록이 없습니다.", BookElementDTO.builder().build());

        return ApiResponse.onSuccess(randomBook);
    }
}
