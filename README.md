# Redis

## Download do Redis

- docker login registry.redhat.io
- docker pull registry.redhat.io/rhscl/redis-5-rhel7 (Esse é o Redis 5)
- docker run -p 6379:6379 --name redis-local registry.redhat.io/rhscl/redis-5-rhel7

## Instalando Redis Desktop Manager:
 
sudo snap install redis-desktop-manager

## Acessando o Redis através do seu client

docker exec -it redis-local sh

redis-cli

ECHO "TESTE" (Esse comando é apenas para testar se o seu redis está ok)...

## Visualizar logs do Redis

docker logs -f redis-local

## Dicas e Padrões

### Convenção para nomear chaves no Redis

Utilizar : para compor um “namespace” na chave é uma convenção
muito utilizada no Redis, sendo que um formato de chave muito
comum assemelha-se com tipo-de-objeto:identificador:nome-campo.
Por exemplo, imagine uma chave utilizando esse formato que represente
o nome dos usuários de um sistema. Essa chave poderia ser da seguinte
forma:
usuario:Rodrigo Lazoti:nome
Sendo que usuario é o tipo de objeto, o valor Rodrigo Lazoti
representa o nome do usuário e nome é o nome do campo que dá significado
ao valor armazenado nesta chave.

## Comandos

SET chave "valor" - Comando para setar uma chave e um valor

MSET chave - Comando que aceita vários conjuntos de chave-valor como parâmetro;

GET chave - Comando para resgatar um valor

MGET chave -  retorna os valores correspondentes às chaves informadas;

DEL chave - Comando que remove um registro baseado na sua chave 

## Realizando buscas no Redis

O Redis possui um comando chamado KEYS , que é usado para
fazer buscar de chaves com base em um determinado padrão (pattern) que é
passado como parâmetro para o comando. Esse padrão (pattern) passado como 
parâmetro para o comando KEYS utiliza o Glob-style pattern matching.


Exemplos:

- O caractere * representa um conjunto de caracteres que podem ser zero
ou mais caracteres. Exemplo: b*a encontraria bala , bela , bola e bicicleta;
- O caractere ? representa um único caractere. Exemplo: b?la encontraria bala , bela e bola ;
- Colchetes[] representam um grupo de caracteres. b[ae]la encontraria bala e bela .
- KEYS * (retorna todas as chaves armazenadas no Redis);



## Referências

https://markheath.net/post/exploring-redis-with-docker

