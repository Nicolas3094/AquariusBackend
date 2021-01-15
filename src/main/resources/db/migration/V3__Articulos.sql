

CREATE TABLE articulos (
    id UUID NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    subtitulo VARCHAR(200) NOT NULL,
    texto VARCHAR NOT NULL,
    vistas INT DEFAULT 0,
    imagen VARCHAR NOT NULL,
    subtema VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE comentario(

    id UUID NOT NULL,
    fecha DATE DEFAULT CURRENT_DATE,
    texto VARCHAR(500),
    PRIMARY KEY(id)
);

CREATE TABLE comentarioArticulo (
    articuloid UUID not null,
    comentario UUID not null,
    FOREIGN KEY(articuloid) REFERENCES articulos (id) ON DELETE CASCADE,
    FOREIGN KEY(comentario) REFERENCES comentario (id),
    PRIMARY KEY(articuloid, comentario)
);

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