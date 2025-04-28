package com.infy.LibraryManagment.repository;

import com.infy.LibraryManagment.model.Txn;
import com.infy.LibraryManagment.model.TxnStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn,Integer> {
    Txn findByUserPhoneNoAndBookBookNoAndTxnStatus(String phoneNo, String bookNo, TxnStatus status);
}
