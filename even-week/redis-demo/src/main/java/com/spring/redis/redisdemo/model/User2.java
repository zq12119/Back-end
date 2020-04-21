package com.spring.redis.redisdemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User2 implements Serializable {
    private Integer id;
    private String username;
    private String address;
}