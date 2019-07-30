package com.example.redisexample.estatisticas;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

public class GerarEstatisticaDePaginasVisitadas {
    private Jedis client = new RedisClient().getClient();

    public void gerarEstatistica(String pagina, String data) {
        String chave = String.format("pagina:%s:%s", pagina, data);
        Jedis jedis = new Jedis("localhost");
        long resultado = jedis.incr(chave);
        System.out.println(
                String.format(
                        "página %s teve %d acesso(s) em %s",
                        pagina,
                        resultado,
                        data
                )
        );
    }
}
