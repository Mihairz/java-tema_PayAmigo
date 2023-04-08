package com.db.PayAmigo.exception;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(){
        super("Insufficient funds to make this transaction.");
    }
}
