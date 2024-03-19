package com.example.library;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Book_Name", nullable = false)
    private String name;

    @Column(name = "Book_Code", nullable = false)
    private String code;

    @Column(name = "Book_Author", nullable = false)
    private String author;
}
