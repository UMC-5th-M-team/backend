package com.umc.mteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umc.mteam.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}