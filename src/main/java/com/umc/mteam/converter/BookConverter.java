package com.umc.mteam.converter;

import com.umc.mteam.domain.Book;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;

public class BookConverter {
    public static BookResponseDTO.EnrollResultDTO toEnrollResultDTO(Book book) {
        return BookResponseDTO.EnrollResultDTO.builder()
        .book_id(book.getId())
        .created_at(book.getCreatedAt())
        .build();
    }

    public static Book toBook(BookRequestDTO.EnRollDTO book) {
        return Book.builder()
        .author(book.getAuthor())
        .bookName(book.getBookName())
        .book_publisher(book.getBookPublisher())
        .description(book.getDescription())
        .page(book.getPage())
        .expire_at(book.getExpireAt())
        .start_at(book.getStartAt())
        .status(book.getStatus())
        .build();
    }

    // book -> bookElementDTO
    public static BookResponseDTO.BookElementDTO toBookElementDTO(Book book) {
        return BookResponseDTO.BookElementDTO.builder()
        .author(book.getAuthor())
        .description(book.getDescription())
        .expire_at(book.getExpire_at())
        .status(book.getStatus())
        .title(book.getBookName())
        .build();
    }
}
