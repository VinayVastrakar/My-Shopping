package com.example.Shoppingverse.controller;

import com.example.Shoppingverse.dto.request.CustomerRequestDto;
import com.example.Shoppingverse.dto.response.CustomerResponseDto;
import com.example.Shoppingverse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        CustomerResponseDto response = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}