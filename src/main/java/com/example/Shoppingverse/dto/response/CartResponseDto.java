package com.example.Shoppingverse.dto.response;

import com.example.Shoppingverse.dto.request.ItemRequestDto;
import com.example.Shoppingverse.model.Item;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {

    String customerName;

    int cartTotal;

    List<ItemResponseDto> items;
}