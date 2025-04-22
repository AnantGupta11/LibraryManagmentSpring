package com.infy.LibraryManagment.dto;

import com.infy.LibraryManagment.model.Author;
import com.infy.LibraryManagment.model.Book;
import com.infy.LibraryManagment.model.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import static com.infy.LibraryManagment.model.Author.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookRequest {
    @NotBlank(message = "Book title should not be blank")
    private String bookTitle;

    @NotBlank(message = "Book No. should not be blank")
    private String bookNo;

    @NotBlank(message = "AuthorName should not be blank")
    private String authorName;

//    public @NotBlank(message = "Author Email should not be blank") String getAuthorEmail() {
//        return authorEmail;
//    }

    @NotBlank(message = "Author Email should not be blank")
    private String authorEmail;

    @NotNull(message = "Book Type should not be blank")
    private BookType type;

    @Positive(message = "Security Amount should  be +ve")
    private int securityAmount;


    public Author toAuthor() {
        return Author.
                builder().
                email(this.authorEmail).
                name(this.authorName).
                build();
    }

    public Book toBook() {
        return Book.
                builder().
                title(this.bookTitle).
                bookNo(this.bookNo).
                bookType(this.type).
                securityAmount(this.securityAmount).
                build();
    }
}
