package com.example.library;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.example.library.Repository.BookRepository;

@DataJpaTest
public class BookRepositoryTests {
    

    @Autowired
    private BookRepository bookRepository;

    //JUnit Test for save books
    @Test
    public void saveBookTest(){

        Book book = Book.builder()
            .name("Fourty Rules of Love")
            .code("002F")
            .author("Elaf Shafak")
            .build();

        bookRepository.save(book);

        Assertions.assertThat(book.getId()).isGreaterThan(0);
    }

    @Test
    public void getBookTest(){

        Book book = bookRepository.findById(1).get();

        Assertions.assertThat(book.getId()).isEqualTo(1L);
    }

    @Test
    public void getListofBooks(){

        java.util.List<Book> books = bookRepository.findAll();

        Assertions.assertThat(books.size()).isGreaterThan(0);
    }

    @Test
    public void updateBookTest(){
        Book book = bookRepository.findById(1).get();
        book.setCode("002");

        Book bookUpdated = bookRepository.save(book);

        Assertions.assertThat(bookUpdated.getCode()).isEqualTo("002");
    }

    @Test
    public void deleteBookTest(){

        Book book = bookRepository.findById(1).get();

        bookRepository.delete(book);

        Book book1 = null;
        Optional<Book> optionalBook = bookRepository.findbyCode("002");

        if (optionalBook.isPresent()) {
            book1 = optionalBook.get();
        }

        Assertions.assertThat(book).isNull();
    }
}
