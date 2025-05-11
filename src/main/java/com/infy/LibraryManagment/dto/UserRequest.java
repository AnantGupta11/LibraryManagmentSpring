package com.infy.LibraryManagment.dto;

import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.model.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static com.infy.LibraryManagment.model.User.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRequest {

    private String userName;

//    @NotBlank(message = "Password should not be blank")
//    private String userPassword;
    @NotBlank(message = "phoneNumber should not be blank")
    private String phoneNo;

    private String email;
    
    private String address;

    @NotBlank(message = "password should not be blank")
    private String password;

    public User toUser() {
        return User.
                builder().
                name(this.userName).
                phoneNo(this.phoneNo).
                email(this.email).
                address(this.address).
                userStatus(UserStatus.ACTIVE).
                build();

    }
}
