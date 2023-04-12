package com.db.controller;

import com.db.dto.LoginRequest;
import com.db.entity.Transaction;
import com.db.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PutMapping("/add")
    public Transaction performPayment(@RequestBody Transaction transaction,
                                      @CookieValue(name = "jwt") String jwt){
        System.out.println("-->CLIENT/TRANSACTION CONTROLLER");
        return transactionService.performPayment(transaction,jwt);
    }
}
