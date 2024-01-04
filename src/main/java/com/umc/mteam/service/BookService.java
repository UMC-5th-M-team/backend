package com.umc.mteam.service;

import org.springframework.stereotype.Service;

import com.umc.mteam.converter.BookConverter;
import com.umc.mteam.domain.Book;
import com.umc.mteam.repository.BookRepository;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponseDTO.EnrollResultDTO enrollBook(BookRequestDTO.EnRollDTO bookRequest) {
        Book book = BookConverter.toBook(bookRequest);
        //BOok-> ResultDTO.id
        // id, request.start_at ->service -> BookGoal Repo -> BookGoal_id 

        return bookRepository.save(book);
    }
}
