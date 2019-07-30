package com.example.redisexample.ttl;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class TesteTTL {
    private static Jedis client = new RedisClient().getClient();
    public static void main(String[] args) {
        createSessao();
        String codigoDoUsuario = "1962";
        String chave = "sessao:usuario:" + codigoDoUsuario;
        int trintaMinutosEmSegundos = 1800;

        // Setando um TTL em Segundos (Time to live para a a chave)
        System.out.println(client.expire(chave,trintaMinutosEmSegundos));

    }

    private static void createSessao(){
        final String codigoDoUsuario = "1962";
        final String nomeDoUsuario = "Peter Parker";
        final String emailDoUsuario = "spidey@marvel.com";
        String chave = "sessao:usuario:" + codigoDoUsuario;
        Map<String, String> campos = new HashMap<String, String>() {{
            put("codigo", codigoDoUsuario);
            put("nome", nomeDoUsuario);
            put("email", emailDoUsuario);
        }};
        String resultado = client.hmset(chave, campos);
        System.out.println(resultado);
    }
}
