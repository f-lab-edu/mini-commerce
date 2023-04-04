package com.flab.commerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String password;

    @Builder
    private Users(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}
