package com.example.redisexample.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class StudentRedisImpl implements Student, Serializable {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
}
