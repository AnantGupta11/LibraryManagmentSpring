package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.model.Author;
import com.infy.LibraryManagment.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author getAuthorData(String email) {
        return authorRepository.getAuthorByEmail(email);
    }
}
