package com.infy.LibraryManagment.repository;

import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "select * from user where :query", nativeQuery = true)
    List<User> findUserByNativeQuery(@Param("query") String q);

    User findByphoneNoAndUserType(String phoneNo, UserType userType);
    User findByEmail(String email) ;
}
