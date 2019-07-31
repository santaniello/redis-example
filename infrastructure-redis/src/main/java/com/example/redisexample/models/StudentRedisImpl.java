package com.example.redisexample.models;

import lombok.Getter;
import lombok.Setter;

public class StudentRedisImpl implements Student{
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
}
