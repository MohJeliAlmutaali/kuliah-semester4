package com.jeli.library_manager.repository;

import com.jeli.library_manager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
