package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.dto.UserRequest;
import com.infy.LibraryManagment.model.Operator;
import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserFilterType;
import com.infy.LibraryManagment.model.UserType;
import com.infy.LibraryManagment.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Log logger = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User addStudent( UserRequest userRequest) {
        User user=userRequest.toUser();
        user.setUserType(UserType.STUDENT);
        return userRepository.save(user);
    }

    public List<User> filter(String filterBy, String operator, String value) {
        String[] filters= filterBy.split(",");
        String[] operators=operator.split(",");
        String[] values=value.split(",");
        StringBuilder query=new StringBuilder();
        query.append("select * from user where ");
        for(int i=0;i<operators.length;i++){
            UserFilterType userFilterType=UserFilterType.valueOf(filters[i]);
            Operator operator1= Operator.valueOf(operators[i]);
            String finalValue=values[i];
            query= query.append(userFilterType).
                    append(operator1.getValue()).append("'").
                    append(finalValue).append("'").append(" ").append("and").append(" ");
        }

        logger.info("query is :" + query.substring(0,query.length()-4));
        return userRepository.findUserByNativeQuery(query.substring(0,query.length()-4).toString());
    }

    public User getStudentByPhone(@NotBlank(message = "userPhoneNo should not be blank") String userPhoneNo) {
        return userRepository.findByphoneNoAndUserType(userPhoneNo, UserType.STUDENT);
    }

//    public User addAdmin(@Valid UserRequest userRequest) {
//    }
}
