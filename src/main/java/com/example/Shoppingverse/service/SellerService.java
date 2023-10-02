package com.example.Shoppingverse.service;

import com.example.Shoppingverse.dto.request.SellerRequestDto;
import com.example.Shoppingverse.dto.response.SellerResponseDto;
import com.example.Shoppingverse.model.Seller;
import com.example.Shoppingverse.repository.SellerRepository;
import com.example.Shoppingverse.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save the entity
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}