package com.ahmetsenocak.bookstore.repository;

import com.ahmetsenocak.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
