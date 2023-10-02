package com.example.Shoppingverse.exception;

public class InvalidCardException extends RuntimeException{

    public InvalidCardException(String message){
        super(message);
    }
}