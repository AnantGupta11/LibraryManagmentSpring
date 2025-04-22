package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.dto.BookRequest;
import com.infy.LibraryManagment.model.Author;
import com.infy.LibraryManagment.model.Book;
import com.infy.LibraryManagment.repository.AuthorRepository;
import com.infy.LibraryManagment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(BookRequest bookRequest) {

        Author authorFromDB = authorRepository.getAuthorByEmail(bookRequest.getAuthorEmail());
        if(authorFromDB == null){
            // object of Author table
            // save the data in author table ?
            authorFromDB = authorRepository.save(bookRequest.toAuthor());
        }
        Book book = bookRequest.toBook();
        book.setAuthor(authorFromDB);
        return bookRepository.save(book);
    }
}
