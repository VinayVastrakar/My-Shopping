package com.example.Shoppingverse.controller;


import com.example.Shoppingverse.Enum.ProductCatagory;
import com.example.Shoppingverse.dto.request.ProductRequestDto;
import com.example.Shoppingverse.dto.response.ProductResponseDto;
import com.example.Shoppingverse.exception.SellerNotFoundException;
import com.example.Shoppingverse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

        try{
            ProductResponseDto response = productService.addProduct(productRequestDto);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_by_category_and_price_greater_than")
    public ResponseEntity getProdByCategoryAndPriceGreaterThan(@RequestParam("price") int price,
                                                               @RequestParam("category") ProductCatagory category){

        List<ProductResponseDto> productResponseDtoList =
                productService.getProdByCategoryAndPriceGreaterThan(price,category);
        return new ResponseEntity(productResponseDtoList,HttpStatus.FOUND);
    }
}