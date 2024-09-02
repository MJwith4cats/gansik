package com.example.study.dto;

import com.example.study.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderItemRequest {

    private int totalPrice;
    private int quantity;

    public OrderItem toEntity(){
        return OrderItem.builder()
                .totalPrice(totalPrice)
                .quantity(quantity)
                .build();
    }
}
