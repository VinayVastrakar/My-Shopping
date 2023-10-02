package com.example.Shoppingverse.repository;

import com.example.Shoppingverse.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}