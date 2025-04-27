package com.infy.LibraryManagment.controller;

import com.infy.LibraryManagment.dto.TxnRequest;
import com.infy.LibraryManagment.exception.TxnException;
import com.infy.LibraryManagment.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    TxnService txnService;

    @PostMapping("/create")
    public String create(@RequestBody TxnRequest txnRequest) throws TxnException {
        return txnService.create(txnRequest);

    }

}
