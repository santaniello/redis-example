package com.example.redisexample.megasena;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

public class TesteMegasena {
    public static void main(String[] args) {
        String dataDoSorteio1 = "04-09-2013";
        String numerosDoSorteio1 = "10, 11, 18, 42, 55, 56";
        String chave1 = String.format("resultado:%s:megasena",dataDoSorteio1);
        String dataDoSorteio2 = "07-09-2013";
        String numerosDoSorteio2 = "2, 21, 30, 35, 45, 50";
        String chave2 = String.format("resultado:%s:megasena",dataDoSorteio2);
        String dataDoSorteio3 = "21-09-2013";
        String numerosDoSorteio3 = "2, 13, 24, 41, 42, 44";
        String chave3 = String.format("resultado:%s:megasena",dataDoSorteio3);
        Jedis client = new RedisClient().getClient();
        String resultado = client.mset(
                chave1, numerosDoSorteio1,
                chave2, numerosDoSorteio2,
                chave3, numerosDoSorteio3
        );
        System.out.println(resultado);
    }
}
