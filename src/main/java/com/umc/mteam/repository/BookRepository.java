package com.umc.mteam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umc.mteam.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> getBooksListByUserId(Long userId);

    public Book getBookByUserIdAndId(Long userId, Long id);
}
