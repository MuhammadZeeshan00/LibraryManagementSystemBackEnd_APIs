package com.example.library.Controller;

import com.example.library.Book;
import com.example.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/addBook")
    public Book AddBook(@RequestBody Book book)
    {
        return bookService.saveBook(book);
    }

    @GetMapping("/getBooks")
    public List<Book> GetBooks()
    {
        return bookService.getBooks();
    }

    @GetMapping("/getBookById")
    public Book GetBookById(String Name)
    {
        return bookService.getBookById(Name);
    }

    @DeleteMapping("/deleteBook")
    public String DeleteBook(int Id)
    {
        return bookService.deleteBook(Id);
    }

    @PutMapping("/updateBook")
    public Book UpdateBook(Book book)
    {
        return bookService.updateBook(book);
    }
}
