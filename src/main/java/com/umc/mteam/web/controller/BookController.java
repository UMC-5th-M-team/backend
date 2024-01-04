package com.umc.mteam.web.controller;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.mteam.ApiPayload.ApiResponse;
import com.umc.mteam.service.BookService;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/book/")
public class BookController {
    private final BookService bookService;

    @PostMapping("/home")
    public ApiResponse<BookResponseDTO.EnrollResultDTO> enrollBook(
        @RequestBody BookRequestDTO.EnRollDTO enRollDTO, @RequestParam("user_id") Long userId
        ) {
            BookResponseDTO.EnrollResultDTO resultDTO = bookService.enrollBook(enRollDTO);
            return ApiResponse.onSuccess(resultDTO);
    }
    
}
