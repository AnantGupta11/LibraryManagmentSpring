package com.infy.LibraryManagment.repository;

import com.infy.LibraryManagment.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn,Integer> {
}
