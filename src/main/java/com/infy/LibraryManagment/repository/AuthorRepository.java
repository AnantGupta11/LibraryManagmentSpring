package com.infy.LibraryManagment.repository;

import com.infy.LibraryManagment.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    // native Query
    @Query(value = "select * from author where email = :email", nativeQuery = true)
    Author getAuthorByEmail(String email);

}
