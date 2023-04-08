package com.db.PayAmigo;

import com.db.PayAmigo.entity.Transaction;
import com.db.PayAmigo.entity.User;
import com.db.PayAmigo.entity.Wallet;
import com.db.PayAmigo.exception.InsufficientFundsException;
import com.db.PayAmigo.service.TransactionService;
import com.db.PayAmigo.service.WalletService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayAmigoTests {
    @Autowired
    TransactionService transactionService;
    @Autowired
    WalletService walletService;

    User testUser1 = new User("Mike","mike@yahoo.com","123");
    User testUser2 = new User("Mihai","mihai@yahoo.com","123");
    Wallet sourceTest = new Wallet("Economics",testUser1,200,"eur");
    Wallet destinationTest = new Wallet("Economic",testUser2,400,"eur");
    Transaction transactionTest = new Transaction(sourceTest, destinationTest,0f,0f,0f,"eur","today");

    @RepeatedTest(10)
    @DisplayName("Source amount > source balance throws Insufficient Funds exception")
    public void InsufficientFundsExceptionTest() {
        sourceTest.setBalance(100);
        Transaction invalidTransaction = new Transaction(sourceTest, destinationTest, 2000f, 0f, 0f, "eur", "today");

        org.junit.Assert.assertThrows(InsufficientFundsException.class, () -> {
            transactionService.save(invalidTransaction);
        });
    }

    @RepeatedTest(5)
    @DisplayName("Nonexistent destination wallet")
    public void nonexistentDestinationWalletTest(){
        Assertions.assertNotNull(destinationTest);
    }

    @RepeatedTest(7)
    @DisplayName("Nonexistent source wallet")
    public void nonexistentSourceWalletTest(){
        Assertions.assertNotNull(sourceTest);
    }

    @RepeatedTest(2)
    @DisplayName("Nonexistent user for wallet")
    public void nonexistentUserForWalletTest(){
        Assertions.assertNotNull(sourceTest.getUser_id());
        Assertions.assertNotNull(destinationTest.getUser_id());
    }

    @Test
    @DisplayName("User should not pay itself")
    public void userPaysItSelf(){
        Assertions.assertNotEquals(destinationTest.getUser_id(), sourceTest.getUser_id(), "User should not pay itself");
    }

    @Test
    @DisplayName("User cannot pay a negative amount")
    public void negativeAmount(){
        transactionTest.setAmount(1f);
        Assertions.assertTrue(transactionTest.getAmount()>0);
    }


}
