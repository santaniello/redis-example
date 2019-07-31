package com.example.redisexample.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentMongoImpl implements Student{
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
}
