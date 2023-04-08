package com.db.PayAmigo;

import com.db.PayAmigo.entity.Transaction;
import com.db.PayAmigo.entity.Wallet;
import com.db.PayAmigo.exception.InsufficientFundsException;
import com.db.PayAmigo.exception.NonexistentDestinationError;
import com.db.PayAmigo.service.TransactionService;
import com.db.PayAmigo.service.WalletService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayAmigoTests {
    @Autowired
    TransactionService transactionService;
    @Autowired
    WalletService walletService;
//    @Test
//    @DisplayName("Source amount > source balance throws Insufficient Funds exception")
//    public void InsufficientFundsExceptionTest(){
//        Wallet source = new Wallet();
//        source.setBalance(100);
//        Wallet destination = walletService.findBywalletId(5);
//        Transaction invalidTransaction = new Transaction(source,destination,2000f,0f,0f,"eur","today");
//
//        org.junit.Assert.assertThrows(InsufficientFundsException.class,()->{transactionService.save(invalidTransaction);});
//    }

    @Test
    @DisplayName("Nonexistent destination wallet")
    public void nonexistentDestinationWalletTest(){
        Wallet source = new Wallet();
        Wallet destination = new Wallet();
        Transaction invalidTransaction = new Transaction(source,destination,0f,0f,0f,"eur","today");
        org.junit.Assert.assertThrows(NonexistentDestinationError.class,()->{transactionService.save(invalidTransaction);});
    }

}
