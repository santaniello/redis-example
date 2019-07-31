package com.example.redisexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Map;

@Configuration
public class RedisUtil<T> {
    private RedisTemplate<String,T> redisTemplate;
    private HashOperations<String,Object,T> hashOperation;
    private ListOperations<String,T> listOperation;
    private ValueOperations<String,T> valueOperations;

    @Autowired
    RedisUtil(RedisTemplate<String,T> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperation = redisTemplate.opsForHash();
        this.listOperation = redisTemplate.opsForList();
        this.valueOperations = redisTemplate.opsForValue();
    }

    public void putMap(RedisKey<T> key) {
        hashOperation.put(key.getKeyName(), key.getKey(), key.getValue());
    }

    public T getMapAsSingleEntry(RedisKey<T> key) {
        return  hashOperation.get(key.getKeyName(),key.getKey());
    }

    public Map<Object, T> getMapAsAll(RedisKey<T> key) {
        return hashOperation.entries(key.getKeyName());
    }

    public void putValue(RedisKey<T> key) {
       valueOperations.set(key.getKeyName(), key.getValue());
    }

    public void putValueWithExpireTime(RedisKey<T> key) {
        valueOperations.set(key.getKeyName(), key.getValue(), key.getTimeout(), key.getUnit());
    }

    public T getValue(String key) {
        return valueOperations.get(key);
    }

    public void setExpire(RedisKey<T> key){
       redisTemplate.expire(key.getKeyName(), key.getTimeout(), key.getUnit());
    }

}
