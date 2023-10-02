package com.example.Shoppingverse.transformer;

import com.example.Shoppingverse.dto.request.ItemRequestDto;
import com.example.Shoppingverse.dto.response.ItemResponseDto;
import com.example.Shoppingverse.model.Item;

public class ItemTransformer {

    public static Item ItemRequestDtoToItem(int requiredQuantity){

        return Item.builder()
                .requiredQuantity(requiredQuantity)
                .build();
    }

    public static ItemResponseDto ItemToItemResponseDto(Item item){

        return ItemResponseDto.builder()
                .itemPrice(item.getProduct().getPrice())
                .itemName(item.getProduct().getProductName())
                .quantityAdded(item.getRequiredQuantity())
                .category(item.getProduct().getCategory())
                .build();
    }
}