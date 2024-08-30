package com.example.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id",updatable = false)
    private long id;
    private String orderItems;

    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orders = new ArrayList<>();

    @Builder
    public Order(String orderItems, List<OrderItem> orders) {
        this.orderItems = orderItems;
        this.orders = orders;
    }

    public void addOrderItem(OrderItem item) {
        orders.add(item);
        item.setOrder(this); // 양방향 관계 설정
    }

    public void setOrder(List<OrderItem> orders) {
        this.orders = orders;
    }


}
