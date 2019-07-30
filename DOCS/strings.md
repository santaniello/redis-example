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




