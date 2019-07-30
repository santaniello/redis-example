package com.example.redisexample.list;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

public class TesteLista {
    private static Jedis client = new RedisClient().getClient();

    public static void main(String[] args) {
        String chave = "ultimas_paginas_visitadas";
        String[] paginasVisitadas = {
                "/inicio",
                "/contato",
                "/sobre-mim",
                "/todos-os-posts",
                "/armazenando-dados-no-redis"
        };

        Long resultado = client.lpush(chave, paginasVisitadas);
        System.out.println(
                String.format(
                  "A lista %s contém %d elementos", chave, resultado
                )
        );

        // verificando o tamanho da lista
        System.out.println(client.llen(chave));
    }

}
