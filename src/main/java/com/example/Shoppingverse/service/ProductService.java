package com.example.Shoppingverse.service;

import com.example.Shoppingverse.Enum.ProductCatagory;
import com.example.Shoppingverse.dto.request.ProductRequestDto;
import com.example.Shoppingverse.dto.response.ProductResponseDto;
import com.example.Shoppingverse.exception.SellerNotFoundException;
import com.example.Shoppingverse.model.Product;
import com.example.Shoppingverse.model.Seller;
import com.example.Shoppingverse.repository.CustomerRepository;
import com.example.Shoppingverse.repository.ProductRepository;
import com.example.Shoppingverse.repository.SellerRepository;
import com.example.Shoppingverse.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        Seller seller = sellerRepository.findByEmailId(productRequestDto.getSellerEmail());
        if (seller == null) {
            throw new SellerNotFoundException("Seller doesn't exist");
        }

        // dto -> entity
        Product product = ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller); // save both product and seller
        List<Product> productList = savedSeller.getProducts();
        Product latestProduct = productList.get(productList.size() - 1);

        // prepare response dto
        return ProductTransformer.ProductToProductResponseDto(latestProduct);
    }

    public List<ProductResponseDto> getProdByCategoryAndPriceGreaterThan(int price,
                                                                         ProductCatagory category) {

        List<Product> products = productRepository.getProdByCategoryAndPriceGreaterThan(price,category);

        // prepare list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            productResponseDtos.add(ProductTransformer.ProductToProductResponseDto(product));
        }

        return productResponseDtos;

    }
}