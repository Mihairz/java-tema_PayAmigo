package com.db.PayAmigo.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(int id){super("User with id:" + id + " not found");}
}
