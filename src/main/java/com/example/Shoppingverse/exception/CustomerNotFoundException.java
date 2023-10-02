package com.example.Shoppingverse.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){

        super(message);
    }
}