package com.example.redisexample.list.fila;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

public class ArmazenarItemNaFila {
    private static Jedis client = new RedisClient().getClient();

    public void agendarAutorizacaoDeUsuario(String nome,  String email) {
        String chave = "fila:confirmar-usuario";
        String mensagem = String.format("{\"nome\": \"%s\", \"email\": \"%s\"}", nome, email);
        Long resultado = client.rpush(chave, mensagem);
        System.out.println(String.format("A fila %s contém %d tarefa(s).", chave, resultado));
    }

    public static void main(String[] args) {
        ArmazenarItemNaFila fila = new ArmazenarItemNaFila();
        fila.agendarAutorizacaoDeUsuario(
                "Daenerys Targaryen", "daenerys@targaryen.com"
        );
        fila.agendarAutorizacaoDeUsuario(
                "Jon Snow", "jon@snow.com"
        );
        fila.agendarAutorizacaoDeUsuario(
                "Tyrion Lannister", "tyrion@lannister.com"
        );
    }
}
