package com.umc.mteam.web.controller;

import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.mteam.ApiPayload.ApiResponse;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/book/")
public class BookController {
    

    @PostMapping("/home")
    public ApiResponse<BookResponseDTO.EnrollResultDTO> enrollBook(
        @RequestBody BookRequestDTO.EnRollDTO enRollDTO, @RequestParam("user_id") Long userId
        ) {
            
        
        return enRollDTO;
    }
    
}
