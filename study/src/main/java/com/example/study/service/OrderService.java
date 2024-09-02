package com.example.study.service;

import com.example.study.domain.Order;
import com.example.study.domain.OrderItem;
import com.example.study.dto.OrderRequest;
import com.example.study.repository.OrderItemRepository;
import com.example.study.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest){
        Order order = orderRequest.toEntity();

        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }

        return orderRepository.save(order);
    }
}
