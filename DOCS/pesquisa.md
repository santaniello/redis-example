# Pesquisando Dados Utilizando Redis

O Redis possui um comando chamado KEYS , que é usado para fazer buscar de chaves com base em um determinado padrão (pattern) que é
passado como parâmetro para o comando. Esse padrão (pattern) passado como 
parâmetro para o comando KEYS utiliza o Glob-style pattern matching.

Exemplos:

- O caractere * representa um conjunto de caracteres que podem ser zero ou mais caracteres. Exemplo: b*a encontraria bala , bela , bola e bicicleta;
- O caractere ? representa um único caractere. Exemplo: b?la encontraria bala , bela e bola ;
- Colchetes[] representam um grupo de caracteres. b[ae]la encontraria bala e bela .
- KEYS * (retorna todas as chaves armazenadas no Redis);

Exemplo: [Exemplo de Uso Keys](../src/main/java/com/example/redisexample/megasena/FiltrarHistoricoDaMegaSena.java)


