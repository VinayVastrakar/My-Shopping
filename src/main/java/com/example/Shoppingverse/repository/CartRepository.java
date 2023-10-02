package com.example.Shoppingverse.repository;

import com.example.Shoppingverse.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer>{
}
