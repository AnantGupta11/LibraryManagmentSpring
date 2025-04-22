package com.infy.LibraryManagment.controller;

import com.infy.LibraryManagment.dto.UserRequest;
import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserStatus;
import com.infy.LibraryManagment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    private User addStudent(@RequestBody  UserRequest userRequest){
        return userService.addStudent(userRequest);
    }

    @PostMapping("/addAdmin")
    private User addAdmin(@RequestBody  UserRequest userRequest){
        return null;
    }
}
