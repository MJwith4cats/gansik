package com.example.study.controller;

import com.example.study.domain.Order;
import com.example.study.dto.AddOrderRequest;
import com.example.study.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody AddOrderRequest request){
        Order saveOrder = orderService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveOrder);
    }
}
