package com.example.Shoppingverse.repository;

import com.example.Shoppingverse.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

    public Seller findByEmailId(String email);
}