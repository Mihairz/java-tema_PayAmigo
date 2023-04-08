package com.db.PayAmigo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.db.PayAmigo.entity.User;
import com.db.PayAmigo.entity.Wallet;
import org.junit.Before;
import org.junit.Test;

    public class SubstractTest {

        private Wallet wallet;

        @Before
        public void setup() {
            wallet = new Wallet();
            wallet.setId(1);
            wallet.setName("Test Wallet");
            wallet.setUser_id(new User());
            wallet.setBalance(100.0);
            wallet.setCurrency("USD");
        }

        @Test
        public void testSubstract() {
            double amount = 50.0;
            assertTrue(wallet.getBalance() >= amount);

            wallet.substract(amount);

            assertEquals(wallet.getBalance(), 50.0, 0.0);
        }

        @Test
        public void testSubstractWithInsufficientBalance() {
            double amount = 200.0;
            assertFalse(wallet.getBalance() >= amount);

            try {
                wallet.substract(amount);
            } catch (IllegalArgumentException e) {
                assertEquals(wallet.getBalance(), 100.0, 0.0);
                return;
            }
            assertTrue(false);
        }
    }
