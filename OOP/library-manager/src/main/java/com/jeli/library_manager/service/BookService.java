package com.jeli.library_manager.service;

import com.jeli.library_manager.model.Book;
import com.jeli.library_manager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id_book) {
        return bookRepository.findById(id_book);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id_book) {
        bookRepository.deleteById(id_book);
    }
}
