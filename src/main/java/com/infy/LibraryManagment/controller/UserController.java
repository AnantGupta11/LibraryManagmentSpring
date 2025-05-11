package com.infy.LibraryManagment.controller;

import com.infy.LibraryManagment.dto.UserRequest;
import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserStatus;
import com.infy.LibraryManagment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    private User addStudent(@RequestBody @Valid UserRequest userRequest){
        return userService.addStudent(userRequest);
    }

    @PostMapping("/addAdmin")
    private User addAdmin(@RequestBody @Valid UserRequest userRequest){
        return userService.addAdmin(userRequest);
    }

    @GetMapping("/filter")
    public List<User> filter(@RequestParam("filterBy")String filterBy,
                             @RequestParam("operator")String operator,
                             @RequestParam("values") String values){
        return userService.filter(filterBy,operator,values);
    }
}
