package com.example.study.dto;

import com.example.study.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddOrderItemRequest {

    private long orderId;
    //주문과의 관계를 설정하는 필드가 필요해서 orderId를 추가
    //어떤 주문에 속하는지 명시할 수 있음
    private int totalPrice;
    private int quantity;

    public OrderItem toEntity(){
        return OrderItem.builder()
                .totalPrice(totalPrice)
                .quantity(quantity)
                .build();
    }
}
