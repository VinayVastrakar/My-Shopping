package com.example.Shoppingverse.model;

import com.example.Shoppingverse.Enum.ProductCatagory;
import com.example.Shoppingverse.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class Product {

    String productName;
    int price;
    int availbleQuantity;

    ProductCatagory productCatagory;

    ProductStatus productStatus;


    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();
}
