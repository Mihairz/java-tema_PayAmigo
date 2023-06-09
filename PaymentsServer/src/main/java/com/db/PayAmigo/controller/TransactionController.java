package com.db.PayAmigo.controller;

import com.db.PayAmigo.entity.Transaction;
import com.db.PayAmigo.exception.InsufficientFundsException;
import com.db.PayAmigo.exception.UserNotFoundException;
import com.db.PayAmigo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Get all Transactions---------------------------------------------------------------------------------------------

    @GetMapping("/all-json")
    public List<Transaction> getAllTransactionsJSON() {
        return transactionService.findAllTransactions();
    }

    // Get Transaction by TransactionId---------------------------------------------------------------------------------

    @GetMapping("/by-id-json/{transactionId}")
    public Optional<Transaction> findTransactionByIdJSON(@PathVariable(name = "transactionId") int TransactionId) {
        return transactionService.findByTransactionId(TransactionId);
    }


    // Add Transaction--------------------------------------------------------------------------------------------------

    @PutMapping("/add-json")
    public Transaction addTransactionJSON(Transaction transaction,
                                          String jwt) throws InsufficientFundsException, UserNotFoundException {
        return transactionService.save(transaction,jwt);
    }

    // Update Transaction-----------------------------------------------------------------------------------------------

//    @PostMapping("/update-json/{id}")
//    public Transaction updateTransactionJSON(@PathVariable(name = "id") int id,
//                                             @RequestBody Transaction transaction) {
//        return transactionService.updateTransaction(id, transaction);
//    }

    // Delete Transaction-----------------------------------------------------------------------------------------------
    @DeleteMapping("/delete/{transactionId}")
    public void deleteTransaction(@PathVariable(name = "transactionId") int TransactionId) {
        transactionService.deleteTransaction(TransactionId);
    }
}
