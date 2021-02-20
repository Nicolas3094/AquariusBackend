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

## Vistas

    CREATE VIEW pedidosview as
    SELECT
        B.pedido as "pedido",
        V.producto as "producto",
        V.cliente as "cliente",
        B.fecha as "fecha de pedido",
        B.status as "satus"
    FROM
    (SELECT
        D.productoID as "producto",
        U.clienteID as "cliente"
    FROM productopedidos D
    JOIN UsuarioPedido U
    ON D.pedidoID = U.pedidoID) V
    JOIN
        (SELECT
            Pd.pedidoid as "pedido",
            Pd.productoid as "producto",
            O.fecha_pedido as "fecha",
            O.status_pedido as "status"
        from productopedidos Pd JOIN pedidos O
        on Pd.pedidoID = O.numeroPedido) B
        on V.producto = B.producto;
### Nota

Aún me reúso a utilizarla paquetería de Spring Data JPA por razones que deja casi aun lado el lenguaje SQL.

### Autor
José Nicolás Agustín G. M.
