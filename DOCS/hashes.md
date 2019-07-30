## Utilizando hashes

No Redis, um hash nada mais é do que um map que contém campos e valores do tipo string. Este tipo de dado é muito utilizado para representar objetos
definidos em nossas aplicações, como por exemplo um usuário que contém um nome, e-mail e data de nascimento. Cada hash pode armazenar mais de
4 bilhões de pares de campo-valor [1]. Utilizando um hash podemos definir vários conjuntos de campo-valor
para uma única chave.

Exemplo: 

chave:  campo:valor
        campo:valor
        campo:valor
        
        
livro-001:  nome:Armazenando dados com Redis
            autor: Rodrigo Lazoti
            editora: Casa do Código
        
### Referência rápida de comandos para hashes

- HDEL chave campo [campo ...] — remove o(s) campo(s) e seu(s) respectivo(s) valor(es) do hash informado;
- HEXISTS chave campo — determina se um hash e seu campo existem;
- HGET chave campo — retorna o valor do campo associado ao hash informado;
- HLEN hash — retorna a quantidade de campos que um hash possui;
- HMGET chave campo [campo ...] — retorna os valores de todos os campos informados que são associados a um hash;
- HMSET chave campo valor [campo valor ...] - define múltiplos campos e valores em um hash (No caso do Java utilizando um HashMap);
- HSET chave campo valor — armazena um hash com o campo e seu respectivo valor. Caso o hash e o campo já existam, o valor é sobrescrito.


             