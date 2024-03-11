package com.example.library;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Book_Name")
    private String name;

    @Column(name = "Book_Code")
    private String code;

    @Column(name = "Book_Author")
    private String author;
}
