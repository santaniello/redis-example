package com.example.redisexample.megasena;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class FiltrarHistoricoDaMegaSena {

    private Jedis client = new RedisClient().getClient();

    public Set<String> filtrarResultados(int mes, int ano) {
        String chave = "resultado:*-%02d-%04d:megasena";
        // Filtrando as chaves através do pattern acima...
        return client.keys(String.format(chave, mes, ano));
    }

    public Set<String> filtrarTodosResultados() {
        // * Trás todos os resultados...
        return client.keys("*");
    }



    public static void main(String[] args) {
        int mes = 9;
        int ano = 2013;
        Set<String> chaves = new FiltrarHistoricoDaMegaSena()
                                .filtrarResultados(mes, ano);
        System.out.println(chaves);
    }
}