package com.infy.LibraryManagment.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Book  {
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
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<Txn> txnList;
}
