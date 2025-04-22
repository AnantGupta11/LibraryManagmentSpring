package com.infy.LibraryManagment.controller;

import com.infy.LibraryManagment.model.Author;
import com.infy.LibraryManagment.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/getAuthorData")
    public Author getAuthorData(@RequestParam("authorEmail") String email){
        return authorService.getAuthorData(email);
    }


}
