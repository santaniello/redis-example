package com.example.redisexample.megasena;

import com.example.redisexample.RedisClient;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TesteMegasena {

    private static Jedis client = new RedisClient().getClient();

    public static void main(String[] args) {
        testeMSET();
        testeFiltrarHistoricoDaMegaSenaPorPeriodo();
        testeFiltrarTodoHistoricoDaMegasena();
        testeMGet();

    }

    private static void testeMSET() {
        String dataDoSorteio1 = "04-09-2013";
        String numerosDoSorteio1 = "10, 11, 18, 42, 55, 56";
        String chave1 = String.format("resultado:%s:megasena", dataDoSorteio1);
        String dataDoSorteio2 = "07-09-2013";
        String numerosDoSorteio2 = "2, 21, 30, 35, 45, 50";
        String chave2 = String.format("resultado:%s:megasena", dataDoSorteio2);
        String dataDoSorteio3 = "21-09-2013";
        String numerosDoSorteio3 = "2, 13, 24, 41, 42, 44";
        String chave3 = String.format("resultado:%s:megasena", dataDoSorteio3);
        String resultado = client.mset(
                chave1, numerosDoSorteio1,
                chave2, numerosDoSorteio2,
                chave3, numerosDoSorteio3
        );
        System.out.println(resultado);
    }

    /**
     * Filtrando as chaves do Redis baseado em um periodo específico...
     */
    private static void testeFiltrarHistoricoDaMegaSenaPorPeriodo() {
        int mes = 9;
        int ano = 2013;
        Set<String> chaves = new FiltrarHistoricoDaMegaSena()
                .filtrarResultados(mes, ano);
        System.out.println(chaves);
    }

    /**
     * Filtrando todas as chaves através do comando KEYS (Qualquer dúvida olhar o Readme)
     */
    private static void testeFiltrarTodoHistoricoDaMegasena() {
        Set<String> chaves = new FiltrarHistoricoDaMegaSena()
                .filtrarTodosResultados();
        System.out.println(chaves);
    }

    /**
     * Obtendo os valores de varias chaves do Redis utilizando MGet (Qualquer dúvida olhar o Readme)...
     * Com o MGET podemos obter varios valores de diversas chaves de uma vez só...
     */
    private static void testeMGet() {
        List<String> listaRetorno = new ArrayList<String>();
        Set<String> chaves = new FiltrarHistoricoDaMegaSena().filtrarTodosResultados();
        Jedis client = new RedisClient().getClient();
        for (String chave : chaves) {
            listaRetorno.addAll(client.mget(chave));
        }
        System.out.println(listaRetorno);

    }

    /**
     * Hashs são como se fossem objetos armazenados no Redis (Qualquer dúvida olhar o Readme)...
     */
    private static void testeHashs() {
        String ganhadores = "22";
        String dataSorteio = "09-11-2013";
        String numeros = "8, 18, 26, 42, 56, 58";
        String chave = String.format("resultado:%s:megasena",  dataSorteio);
        // Setando os Hashs
        long resultado1 = client.hset(chave, "ganhadores", ganhadores);
        long resultado2 = client.hset(chave, "numeros", numeros);

        // Obtendo o campo ganhadores
        System.out.println(client.hget(chave,"ganhadores"));

        // Obtendo o campo numeros
        System.out.println(client.hget(chave,"numeros"));



    }

}
