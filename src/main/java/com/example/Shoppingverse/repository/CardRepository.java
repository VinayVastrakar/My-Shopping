package com.example.Shoppingverse.repository;

import com.example.Shoppingverse.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {

    public Card findByCardNo(String cardNo);
}