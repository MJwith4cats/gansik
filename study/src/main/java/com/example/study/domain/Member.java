package com.example.study.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String phone;

    @Embedded
    private Address address;

    @Enumerated(value=EnumType.STRING)
    private MemberGrade grade;

    @Builder
    public Member(String name, String email, String password, String phone, Address address, MemberGrade grade) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.grade = grade;
    }
}
