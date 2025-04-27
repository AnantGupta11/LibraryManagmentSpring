package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.dto.TxnRequest;
import com.infy.LibraryManagment.exception.TxnException;
import com.infy.LibraryManagment.model.*;
import com.infy.LibraryManagment.repository.TxnRepository;
import com.infy.LibraryManagment.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TxnService {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    TxnRepository txnRepository;

    @Transactional(rollbackOn = {TxnException.class})
    public String create(TxnRequest txnRequest) throws TxnException {

        //Student is correct?
        User userFromDb= userService.getStudentByPhone(txnRequest.getUserPhoneNo());

        if(userFromDb== null){
            throw new TxnException("Student does not belong to my library");
        }

        List<Book> books=bookService.filter(BookFilterType.BOOK_NO, Operator.EQUALS, txnRequest.getBookNo());
        if(books.isEmpty()){
            throw new TxnException("Book does not belong to my library");
        }
        Book bookFromDb=books.get(0);
        if(bookFromDb.getUser()!=null){
            throw new TxnException("Book already issued to someone");
        }
        String txnId= UUID.randomUUID().toString();
        Txn txn=Txn.builder()
                .txnId(txnId)
                .user(userFromDb)
                .book(bookFromDb)
                .txnStatus(TxnStatus.ISSUED)
                .build();

         txnRepository.save(txn);

         bookFromDb.setUser(userFromDb);
         bookService.updateBookData(bookFromDb);
         return txnId;
    }
}
