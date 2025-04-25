package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.dto.UserRequest;
import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserType;
import com.infy.LibraryManagment.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addStudent( UserRequest userRequest) {
        User user=userRequest.toUser();
        user.setUserType(UserType.STUDENT);
        return userRepository.save(user);
    }

//    public User addAdmin(@Valid UserRequest userRequest) {
//    }
}
