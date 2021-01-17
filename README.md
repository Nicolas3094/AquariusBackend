#PostgreSQL

Archivo de Dockerfile

    FROM postgres:alpine

# Archivo docker-compose.yml 

    version: '3.1'
    services:
      app:
        container_name: springDB
        build:
          context: demo/
          dockerfile: Dockerfile
        expose:
          - 8080
        ports:
          - 8080:8080
        networks:
          - backend
        depends_on:
          - db
      postgresdb:
        container_name: postgresdb
        build: 
          context: database/
          dockerfile: Dockerfile
        restart: always
        volumes:
        - pgdata:/var/lib/postgresql/data
        ports:
        - 5432:5432
        environment:
          - POSTGRES_PASSWORD=${DATABASE_PASSWORD}
          - POSTGRES_USER=${DATABASE_USER}
          - POSTGRES_DB=${DATABASE_NAME}
        networks:
          - backend
    networks:
      backend:
    volumes:
      pgdata:

### Nota

Aún me reúso a utilizarla paquetería de Spring Data JPA por razones que deja casi aun lado el lenguaje SQL.

### Autor
José Nicolás Agustín G. M.
