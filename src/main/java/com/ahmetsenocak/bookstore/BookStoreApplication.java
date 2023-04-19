package com.ahmetsenocak.bookstore;

import com.ahmetsenocak.bookstore.model.Book;
import com.ahmetsenocak.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .name("Lord of the Rings")
                .author("J.R.R")
                .price(15.0)
                .stock(50).build();
        Book book2 = Book.builder()
                .name("Harry Potter")
                .author("Harmony")
                .price(10.0)
                .stock(50).build();
        Book book3 = Book.builder()
                .name("God of War")
                .author("Crates")
                .price(40.0)
                .stock(50).build();

        bookRepository.saveAll(Arrays.asList(book1,book2,book3));
    }
}
