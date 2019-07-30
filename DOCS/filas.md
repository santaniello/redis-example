# Trabalhando com filas

## Referência rápida de comandos para filas (listas)

- RPUSH chave valor [valor ...] — adiciona um ou mais valores ao final (tail) da lista definida pela chave;
- RPUSHX chave valor — funciona da mesma forma que o comando RPUSH ; a única diferença entre os dois é que o comando RPUSHX insere
um novo item somente em uma lista já existente. Caso a lista informada como parâmetro não exista, o comando retorna o valor 0 e a lista não é criada;
- LPUSHX chave valor — funciona da mesma forma que o comando LPUSH ; a única diferença entre os dois é que o LPUSHX insere um novo 
item somente em uma lista já existente. Caso a lista informada como parâmetro não exista, o comando retorna o valor 0 e a lista não é criada;
- LPOP chave — remove e retorna o primeiro (head) item da lista informadas como parâmetro ou (nil) caso a lista esteja vazia;
- BLPOP chave [chave] timeout — bloqueia a conexão para remover e retornar o primeiro item de uma das listas informadas como
parâmetro durante um tempo máximo definido no parâmetro timeout. Caso o timeout seja definido como 0, a conexão fica bloqueada até que
um item de uma das listas informadas seja removido e retornado pelo comando;
- RPOP chave — remove e retorna o ultimo (tail) item da lista informadas como parâmetro ou (nil) caso a lista esteja vazia;
- BRPOP chave [chave] timeout — bloqueia a conexão para remover e retornar o último item de uma das listas informadas como
parâmetro durante um tempo máximo definido no parâmetro timeout. Caso o timeout seja definido como 0, a conexão fica bloqueada até que
um item de uma das listas informadas seja removido e retornado pelo comando.