package com.example.study.service;

import com.example.study.domain.Order;
import com.example.study.domain.OrderItem;
import com.example.study.dto.AddOrderRequest;
import com.example.study.repository.OrderItemRepository;
import com.example.study.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public Order save(AddOrderRequest request){
        //DTO를 엔티티로 변환
        Order order = request.toEntity();

        //order 저장
        order = orderRepository.save(order);

        //orderItem 저장
        List<OrderItem> orderItems = order.getOrders(); //OrderItem 리스트 가져오기
        for (OrderItem item : orderItems) {
            item.setOrder(order); //Order와의 관계 설정
            orderItemRepository.save(item); //addOrderItem 메서드 호출 -> OrderItem 저장
        }

        return order;
    }
}
