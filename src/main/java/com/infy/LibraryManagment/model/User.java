package com.infy.LibraryManagment.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String name;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @Column(unique = true, length = 40)
    private String email;

    private String address;

    @CreationTimestamp
    private Data createdOn;

    @UpdateTimestamp
    private Date updateOn;

    @Enumerated(value= EnumType.STRING)
    private UserType userType;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany
    private List<Book> bookList;
}

//User may have multiple books
