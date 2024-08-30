package com.example.study.dto;

import com.example.study.domain.Order;
import com.example.study.domain.OrderItem;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddOrderRequest {

    //여러 주문 항목을 포함하고 있기 때문에 각 OrderItem이 Order와 연결될 수 있도록 수정
    //OrderItem을 생성할 때 order 필드를 설정할 수 있도록 toEntity 메서드 수정
    private List<AddOrderItemRequest> orders;
    private String orderItems;

    public Order toEntity(){
        List<OrderItem> orderItemEntities = new ArrayList<>();
        for (AddOrderItemRequest itemRequest : orders) {
            orderItemEntities.add(itemRequest.toEntity());
        }
                return Order.builder()
                .orders(orderItemEntities)
                .orderItems(orderItems)
                .build();
    }
}
