package com.example.Shoppingverse.repository;

import com.example.Shoppingverse.Enum.ProductCatagory;
import com.example.Shoppingverse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.price >= :price and p.category = :category")
    public List<Product> getProdByCategoryAndPriceGreaterThan(int price, ProductCatagory category);
}