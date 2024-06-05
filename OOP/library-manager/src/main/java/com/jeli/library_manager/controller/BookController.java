package com.jeli.library_manager.controller;

import com.jeli.library_manager.model.Book;
import com.jeli.library_manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-books/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add-book")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
