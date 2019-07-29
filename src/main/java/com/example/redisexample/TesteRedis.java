package com.example.redisexample;

import redis.clients.jedis.Jedis;

public class TesteRedis {
    public static void main(String[] args) {
        Jedis client = new RedisClient().getClient();
        // Exibe Mensagem
        String resultadoEcho = client.echo("Ola Redis");
        System.out.printf(resultadoEcho);
        // Criei uma chave com um respectivo valor...
        client.set("ultimo_usuario_logado", "Tony Stark");
        System.out.println(client.get("ultimo_usuario_logado"));
        // Removo a chave...
        client.del("ultimo_usuario_logado");
    }
}
