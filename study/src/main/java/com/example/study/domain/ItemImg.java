package com.example.study.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ItemImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_img_id")
    private Long id;
    private String imgName;
    private String origImgName;
    private String imgUrl;
    private String repImgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;



}
