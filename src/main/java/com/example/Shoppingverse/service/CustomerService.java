package com.example.Shoppingverse.service;

import com.example.Shoppingverse.dto.request.CustomerRequestDto;
import com.example.Shoppingverse.dto.response.CustomerResponseDto;
import com.example.Shoppingverse.model.Cart;
import com.example.Shoppingverse.model.Customer;
import com.example.Shoppingverse.repository.CustomerRepository;
import com.example.Shoppingverse.transformer.CustomerTransformer;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);   // saves both customer and cart;

        // prepare the response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}