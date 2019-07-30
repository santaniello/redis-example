# TTL (Time to Live em chaves do Redis)

## Referência rápida de comandos para expiração de dados

- EXPIRE chave tempo — define um tempo (em segundos) de expiração para uma chave;
- PERSIST chave — remove o tempo de expiração de uma chave;
- PEXPIRE chave tempo — define um tempo (em milissegundos) de expiração para uma chave;
- PTTL chave — retorna o tempo (em milissegundos) de vida restante para expiração da chave;
- TTL chave — retorna o tempo (em segundos) de vida restante para expiração da chave.