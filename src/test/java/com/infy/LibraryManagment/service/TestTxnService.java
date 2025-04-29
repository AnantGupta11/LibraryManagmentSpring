package com.infy.LibraryManagment.service;

import com.infy.LibraryManagment.dto.TxnRequest;
import com.infy.LibraryManagment.exception.TxnException;
import com.infy.LibraryManagment.model.Book;
import com.infy.LibraryManagment.model.Txn;
import com.infy.LibraryManagment.model.User;
import com.infy.LibraryManagment.repository.TxnRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestTxnService {
    @InjectMocks
    private TxnService txnService;

    @Mock
    UserService userService;

    @Mock
    BookService bookService;

    @Mock
    TxnRepository txnRepository;

    @Before
    public void setUp(){
        //txnService=new TxnService();
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(txnService,"validDays","12");
        ReflectionTestUtils.setField(txnService,"finePerDay","2");
    }

//    @Test
//    public void testCalculateFine() throws ParseException {
//         Date date= new SimpleDateFormat("yyyy-MM-dd").parse("2025-04-01");
//        Txn txn= Txn.builder().
//                createdOn(date).
//                build();
//        int calculatedAmount=txnService.calculateFine(txn,100);
//        Assert.assertEquals(70,calculatedAmount);
//    }

    @Test(expected = TxnException.class)
    public void testGetUserFromDB() throws TxnException {
        TxnRequest txnRequest=TxnRequest.builder().build();
        when(userService.getStudentByPhone(any())).thenReturn(null);
        txnService.getUserFromDB(txnRequest);
    }

    @Test
    public void testGetUserFromDBWhenNoException() throws TxnException {
        TxnRequest txnRequest=TxnRequest.builder().build();
        User user=User.builder().id(1).build();
        when(userService.getStudentByPhone(any())).thenReturn(user);
        User output=txnService.getUserFromDB(txnRequest);
        Assert.assertEquals(user.getId(),output.getId());
    }

    @Test
    public void testReturnBook() throws TxnException, ParseException {
        TxnRequest txnRequest=TxnRequest.builder().build();
        User user=User.builder().id(1).build();
        when(userService.getStudentByPhone(any())).thenReturn(user);
        List<Book> books=new ArrayList<>();
        books.add(Book.builder().id(1).bookNo("1").user(user).securityAmount(100).build());
        when(bookService.filter(any(),any(),any())).thenReturn(books);
        Date date= new SimpleDateFormat("yyyy-MM-dd").parse("2025-04-01");
        Txn txn=Txn.builder().id(1).user(user).book(books.get(0)).createdOn(date).build();
        when(txnRepository.findByUserPhoneNoAndBookBookNoAndTxnStatus(any(),any(),any())).thenReturn(txn);
        int fine=txnService.returnBook(txnRequest);
        Assert.assertEquals(70,fine);
    }

}
