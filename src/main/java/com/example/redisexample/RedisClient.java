package com.example.redisexample;

import redis.clients.jedis.Jedis;

public class RedisClient {

    private Jedis jedis;
    private String host = "localhost";
    private int port = 6379;


    public RedisClient(String host, int port){
        this.host = host;
        this.port = port;
        this.jedis = new Jedis(this.host,this.port);
    }

    public RedisClient(String host){
        this.host = host;
        this.jedis = new Jedis(this.host,this.port);
    }

    public RedisClient(){
        this.jedis = new Jedis(this.host,this.port);
    }

    public Jedis getClient(){
        return this.jedis;
    }
}
