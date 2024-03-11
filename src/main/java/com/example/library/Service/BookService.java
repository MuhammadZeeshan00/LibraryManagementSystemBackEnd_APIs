package com.example.library.Service;

import com.example.library.Book;
import com.example.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book saveBook(Book book){

        return bookRepository.save(book);
    }

    public List<Book> getBooks()
    {
        return  bookRepository.findAll();
    }

    public Book getBookById(String name)
    {
        return bookRepository.findByName(name);
    }

    public Book updateBook(Book book)
    {
        Book existingBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCode(book.getCode());
        return bookRepository.save(existingBook);
    }

    public String deleteBook(int id)
    {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Book with ID " + id + " has been deleted successfully.";
        } else {
            return "Book with ID " + id + " does not exist.";
        }
    }
}
