package com.example.Shoppingverse.service;

import com.example.Shoppingverse.dto.request.ItemRequestDto;
import com.example.Shoppingverse.exception.CustomerNotFoundException;
import com.example.Shoppingverse.exception.InsufficientQuantityException;
import com.example.Shoppingverse.exception.ProductNotFoundException;
import com.example.Shoppingverse.model.Customer;
import com.example.Shoppingverse.model.Item;
import com.example.Shoppingverse.model.Product;
import com.example.Shoppingverse.repository.CustomerRepository;
import com.example.Shoppingverse.repository.ProductRepository;
import com.example.Shoppingverse.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exisit");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Product product = productOptional.get();

        // check for required quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not avaiable");
        }

        // create item
        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}