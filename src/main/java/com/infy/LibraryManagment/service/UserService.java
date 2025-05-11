package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.dto.UserRequest;
import com.infy.LibraryManagment.exception.UserException;
import com.infy.LibraryManagment.model.Operator;
import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserFilterType;
import com.infy.LibraryManagment.model.UserType;
import com.infy.LibraryManagment.repository.UserCacheRepository;
import com.infy.LibraryManagment.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private static final Log logger = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    UserCacheRepository userCacheRepository;

    @PersistenceContext
    private EntityManager em;

    @Value("${student.authority}")
    private String studentAuthority;

    @Value("${admin.authority}")
    private String adminAuthority;

    public User addStudent( UserRequest userRequest) {
        User user=userRequest.toUser();
        user.setAuthorities(studentAuthority);
        user.setPassword(encoder.encode(userRequest.getPassword()));
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
        Query query1=em.createNativeQuery(query.substring(0,query.length()-4), User.class);
        return  query1.getResultList();
        //return userRepository.findUserByNativeQuery(query.substring(0,query.length()-4).toString());
    }

    public User getStudentByPhone(@NotBlank(message = "userPhoneNo should not be blank") String userPhoneNo) {
        return userRepository.findByphoneNoAndUserType(userPhoneNo, UserType.STUDENT);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //load data from redis
        // if user is present then get the data
        User user=userCacheRepository.getUser(email);
        if(user!=null){
            return user;
        }
        user= userRepository.findByEmail(email);
        if(user==null){
             new UserException("User details are wrong");
        }
        userCacheRepository.setUser(email,user);
        return user;
    }

    public User addAdmin(UserRequest userRequest) {
        User user=userRequest.toUser();
        user.setAuthorities(adminAuthority);
        user.setPassword(encoder.encode(userRequest.getPassword()));
        user.setUserType(UserType.ADMIN);
        return userRepository.save(user);
    }


//    public User addAdmin(@Valid UserRequest userRequest) {
//    }
}
