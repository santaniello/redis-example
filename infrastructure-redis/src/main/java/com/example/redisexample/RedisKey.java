package com.example.redisexample;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;
@Getter @Setter
public class RedisKey<T> {
    private String keyName;
    private Object key;
    private T value;
    private long timeout;
    private TimeUnit unit;

    public RedisKey(String keyName){
        this.keyName = keyName;
    }
}
