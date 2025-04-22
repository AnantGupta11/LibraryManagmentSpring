package com.infy.LibraryManagment.controller;

import ch.qos.logback.core.util.StringUtil;
import com.infy.LibraryManagment.dto.BookRequest;
import com.infy.LibraryManagment.model.Book;
import com.infy.LibraryManagment.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //@CrossOrigin(origins = "localhost:8081")
    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid BookRequest bookRequest){

        Book book=bookService.addBook(bookRequest);

        //return the accurate/required data
        return book;
    }


}
