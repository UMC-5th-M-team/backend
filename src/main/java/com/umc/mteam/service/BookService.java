package com.umc.mteam.service;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umc.mteam.converter.BookConverter;
import com.umc.mteam.domain.Book;
import com.umc.mteam.repository.BookRepository;
import com.umc.mteam.web.dto.BookRequestDTO;
import com.umc.mteam.web.dto.BookResponseDTO;
import lombok.RequiredArgsConstructor;
import com.umc.mteam.config.*;

import java.util.Random;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final S3Uploader s3Uploader;

    public BookResponseDTO.EnrollResultDTO enrollBook(BookRequestDTO.EnRollDTO bookRequest) throws IOException {

        if(!bookRequest.getImage().isEmpty()) {
            String storedFileName = s3Uploader.upload(bookRequest.getImage(),"images");
            bookRequest.setImageUrl(storedFileName);
        }
        
        Book book = BookConverter.toBook(bookRequest);

        bookRepository.save(book);

        return BookConverter.toEnrollResultDTO(book);
    }

    public List<BookResponseDTO.BookElementDTO> getBooksByUserId(Long userId) {
        List<BookResponseDTO.BookElementDTO> bookList = bookRepository.getBooksListByUserId(userId).stream().map(x -> BookConverter.toBookElementDTO(x)).toList();

        return bookList;
    }

        public BookResponseDTO.BookElementDTO getRandomBookByUserId(Long userId) {
        List<BookResponseDTO.BookElementDTO> bookList = bookRepository.getBooksListByUserId(userId).stream().map(x -> BookConverter.toBookElementDTO(x)).toList();

        if(bookList.isEmpty()) return null;

        return bookList.get(new Random().nextInt(bookList.size()));
    }
}
