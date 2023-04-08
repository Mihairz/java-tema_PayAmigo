package com.db.PayAmigo.service;

import com.db.PayAmigo.entity.Transaction;
import com.db.PayAmigo.entity.Wallet;
import com.db.PayAmigo.exception.InsufficientFundsException;
import com.db.PayAmigo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletService walletService;

    public Optional<Transaction> findByTransactionId(int transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction save(Transaction transaction) throws InsufficientFundsException {
        Wallet source = transaction.getSource_id();
        Wallet destination = transaction.getDestination_id();
        float amount = transaction.getAmount();

        if (amount <= source.getBalance()){
            walletService.findBywalletId(source.getId()).setBalance(source.getBalance() - amount);
            walletService.findBywalletId(destination.getId()).setBalance(destination.getBalance() + amount);
            return transactionRepository.save(transaction);
        }else{
            throw new InsufficientFundsException();
        }
    }

//    public Transaction updateTransaction(int transactionId, Transaction transaction) {
//
//
//        int id = transactionId;
//        Wallet source_id = transaction.getSource_id();
//        Wallet destination_id = transaction.getDestination_id();
//        Float amount = transaction.getAmount();
//        Float commission_percent = transaction.getCommission_percent();
//        Float commission_amount = transaction.getCommission_amount();
//        String currency = transaction.getCurrency();
//        String created_at = transaction.getCreated_at();
//
//        transactionRepository.updateTransaction(source_id,destination_id,amount,commission_percent,commission_amount,
//                currency,created_at,id);
//
//        return transaction;
//    }

    public void deleteTransaction(int transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
