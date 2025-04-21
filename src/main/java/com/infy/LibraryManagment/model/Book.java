package com.infy.LibraryManagment.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String title;

    @Column(length = 20, unique = true)
    private String bookNo;

    @Enumerated(value = EnumType.STRING)
    private BookType bookType;

    private Integer securityAmount;

    @CreationTimestamp(source = SourceType.DB)
    private Data createdOn;

    @UpdateTimestamp
    private Date updateOn;
}
