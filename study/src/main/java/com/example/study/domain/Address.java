package com.example.study.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
public class Address {
    private String postcode;
    private String roadAddress;
    private String detailAddress;

    @Builder
    public Address(String postcode, String roadAddress, String detailAddress) {
        this.postcode = postcode;
        this.roadAddress = roadAddress;
        this.detailAddress = detailAddress;
    }
}
