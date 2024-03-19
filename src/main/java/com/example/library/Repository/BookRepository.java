package com.example.library.Repository;

import com.example.library.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByName(String name);

    Optional<Book> findbyCode(String Code);

}
