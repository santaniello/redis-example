package com.example.redisexample.estatisticas;

public class TestaGeradorDeEstatisticasDePaginasVisitadas {

    public static void main(String[] args) {
        String data = "02/09/2013";
        String[] paginasVisitadas = {
                "/inicio",
                "/contato",
                "/sobre-mim",
                "/todos-os-posts",
                "/armazenando-dados-no-redis"
        };

        GerarEstatisticaDePaginasVisitadas gerador = new GerarEstatisticaDePaginasVisitadas();
        gerador.gerarEstatistica(paginasVisitadas[0], data);
        gerador.gerarEstatistica(paginasVisitadas[1], data);
        gerador.gerarEstatistica(paginasVisitadas[2], data);
        gerador.gerarEstatistica(paginasVisitadas[1], data);
        gerador.gerarEstatistica(paginasVisitadas[1], data);
    }

}
