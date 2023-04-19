package com.ahmetsenocak.bookstore.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table // Bu bir table classi oldugunu belirtiyor
@Data
@Getter
@Setter
@Builder
public class Book {
    @Id // primary key oldugnu belirtiyor
    @GeneratedValue(strategy = GenerationType.AUTO) //1 den basla arttir
    private Integer id;

    private String name;
    private String author;
    private Double price;
    private Integer stock;
}
