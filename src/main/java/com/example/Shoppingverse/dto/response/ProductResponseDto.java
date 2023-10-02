package com.example.Shoppingverse.dto.response;


import com.example.Shoppingverse.Enum.ProductCatagory;
import com.example.Shoppingverse.Enum.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String sellerName;

    String productName;

    int price;

    int availableQuantity;

    ProductCatagory category;

    ProductStatus productStatus;
}