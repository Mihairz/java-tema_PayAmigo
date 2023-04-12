package com.db.service;

import com.db.clients.TransactionClient;
import com.db.dto.LoginRequest;
import com.db.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionClient transactionClient;

    public Transaction performPayment(Transaction transaction,String jwt){
        System.out.println("-->CLIENT/ TRANSACTION SERVICE");
        return transactionClient.performPayment(transaction);
    }
}
