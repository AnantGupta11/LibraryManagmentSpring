package com.infy.LibraryManagment.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class User  {
    public UserType setUserType;
    //public UserType setUserType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String name;

    private String password;

    private String authorities;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNo;

    @Column(length = 50)
    private String email;

    private String address;

    @CreationTimestamp
    private Date createdOn;


    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Enumerated
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Book> bookList;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    //@JsonIgnoreProperties(value = {"user", "book"})
    private List<Txn> txnList;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String[] auth = authorities.split(",");
//        return Arrays.stream(auth).map(a -> new SimpleGrantedAuthority(a)).collect(Collectors.toList());
//    }

//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}

//User may have multiple books
