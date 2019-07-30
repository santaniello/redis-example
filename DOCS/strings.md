# Trabalhando com Strings no Redis

### Referência rápida de comandos para Strings

- APPEND chave valor — adiciona o valor a uma chave existente, ou cria uma nova chave (caso esta ainda não exista) com seu respectivo valor;
- DEL chave [chave ...] — remove a(s) chave(s) informada(s) e seu(s) respectivo(s) valor(es);
- GET chave — retorna o valor correspondente à chave informada;
- GETRANGE chave inicio fim — retorna uma parte da string armazenada conforme a chave informada;
- MGET chave [chave ...] — retorna os valores correspondentes às chaves informadas;
- MSET chave valor [chave valor ...] — armazena um ou mais conjuntos de chave valor. Caso uma chave informada já exista, seu valor será sobrescrito pelo novo;
- SET chave valor — armazena a chave e seu respectivo valor. Caso já exista uma chave definida, seu valor é sobrescrito;
- STRLEN chave — retorna o tamanho da string armazenada conforme a chave informada.

## Realizando buscas no Redis

O Redis possui um comando chamado KEYS , que é usado para fazer buscar de chaves com base em um determinado padrão (pattern) que é
passado como parâmetro para o comando. Esse padrão (pattern) passado como 
parâmetro para o comando KEYS utiliza o Glob-style pattern matching.

Exemplos:

- O caractere * representa um conjunto de caracteres que podem ser zero ou mais caracteres. Exemplo: b*a encontraria bala , bela , bola e bicicleta;
- O caractere ? representa um único caractere. Exemplo: b?la encontraria bala , bela e bola ;
- Colchetes[] representam um grupo de caracteres. b[ae]la encontraria bala e bela .
- KEYS * (retorna todas as chaves armazenadas no Redis);

