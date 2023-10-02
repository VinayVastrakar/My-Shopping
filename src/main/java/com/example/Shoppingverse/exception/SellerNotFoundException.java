package com.example.Shoppingverse.exception;

import com.example.Shoppingverse.repository.SellerRepository;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(String message){
        super(message);
    }
}