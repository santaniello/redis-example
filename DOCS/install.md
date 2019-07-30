# Instalando o Redis

## Download do Redis

- docker login registry.redhat.io
- docker pull registry.redhat.io/rhscl/redis-5-rhel7 (Esse é o Redis 5)
- docker run -p 6379:6379 --name redis-local registry.redhat.io/rhscl/redis-5-rhel7

## Acessando o Redis através do seu client

docker exec -it redis-local sh

redis-cli

ECHO "TESTE" (Esse comando é apenas para testar se o seu redis está ok)...

## Instalando Redis Desktop Manager:
 
sudo snap install redis-desktop-manager

## Visualizar logs do Redis

docker logs -f redis-local
