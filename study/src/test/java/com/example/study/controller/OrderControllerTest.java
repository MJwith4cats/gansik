package com.example.study.controller;

import com.example.study.domain.OrderItem;
import com.example.study.dto.OrderItemRequest;
import com.example.study.dto.OrderRequest;
import com.example.study.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
//@SpringBootApplication이 있는 클래스를 찾고,
//그 클래스에 포함되어 있는 빈을 찾은 후 테스트용 애플리케이션 컨텍스트를 만듦
@AutoConfigureMockMvc //MockMvc를 생성하고 자동으로 구성
class OrderControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    //애플리케이션을 서버에 배포하지 않고도 테스트용 MVC환경을 만들어 요청 및 전송, 응답 기능을 제공하는 유틸리티 클래스
    //컨트롤러를 테스트할 때 사용하는 클래스

    @Autowired
    protected ObjectMapper objectMapper; //직렬화, 역직렬화

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach //테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @AfterEach //테스트 실행 후 실행하는 메서드
    public void cleanUp(){
        orderRepository.deleteAll();
    }

    @DisplayName("addOrder : 주문 추가에 성공한다")
    @Test
    public void addOrder() throws Exception{
        //given
        final String url = "/api/orders";
        List<OrderItemRequest> orders = List.of(
                new OrderItem(3000, 2), // 예시로 OrderItem 생성
                new OrderItem(5000, 3)
        );
        final OrderRequest orderRequest = new OrderRequest(orders);

        //객체 JSON으로 직렬화
//        final String requestBody = objectMapper.writeValueAsString()

    }
}