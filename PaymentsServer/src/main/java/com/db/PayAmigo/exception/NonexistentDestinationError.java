package com.db.PayAmigo.exception;

public class NonexistentDestinationError extends Exception{
    public NonexistentDestinationError(){
        super("Destination wallet does not exist");
    }
}
