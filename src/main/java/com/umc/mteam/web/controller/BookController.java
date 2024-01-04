package com.umc.mteam.web.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.umc.mteam.ApiPayload.ApiResponse;
import com.umc.mteam.service.BookService;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;


import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/book/")
public class BookController {
    private final BookService bookService;

    @ResponseBody 
    @PostMapping(path = "/home")
    public ApiResponse<BookResponseDTO.EnrollResultDTO> enrollBook(
        BookRequestDTO.EnRollDTO enRollDTO, @RequestParam("user_id") Long userId
    ) throws IOException {
            BookResponseDTO.EnrollResultDTO resultDTO = bookService.enrollBook(enRollDTO);
            return ApiResponse.onSuccess(resultDTO);
    }
}
