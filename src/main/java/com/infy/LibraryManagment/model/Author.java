package com.infy.LibraryManagment.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp(source = SourceType.DB)
    private Data createdOn;

    @UpdateTimestamp
    private Date updateOn;

    @Column(length = 30)
    private String name;

    @Column(unique = true, length = 40, nullable = false)
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
}
