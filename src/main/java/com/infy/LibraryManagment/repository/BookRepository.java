package com.infy.LibraryManagment.repository;

import com.infy.LibraryManagment.model.Book;
import com.infy.LibraryManagment.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitle(String title);
    List<Book> findByTitleContaining(String title);
    List<Book> findByBookType(BookType bookType);

}
