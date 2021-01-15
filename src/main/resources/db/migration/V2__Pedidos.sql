CREATE TABLE pedidos(
    numeroPedido INT NOT NULL,
    fecha_pedido DATE NOT NULL,
    status_pedido VARCHAR(200) NOT NULL,
    PRIMARY KEY(numeroPedido)
);

CREATE TABLE productopedidos(
    pedidoID INT NOT NULL,
    productoID UUID NOT NULL,
    FOREIGN KEY(pedidoID) REFERENCES pedidos (numeroPedido) ON DELETE CASCADE,
    FOREIGN KEY(productoID) REFERENCES producto (id),
    PRIMARY KEY(pedidoID, productoID)
);
CREATE TABLE UsuarioPedido(
     pedidoID INT NOT NULL,
     clienteID UUID NOT NULL,
     FOREIGN KEY(pedidoID) REFERENCES pedidos (numeroPedido) ON DELETE CASCADE,
     FOREIGN KEY(clienteID) REFERENCES usuario (id),
     PRIMARY KEY(pedidoID, clienteID)
);

CREATE TABLE direccion (
    id UUID NOT NULL,
    calle VARCHAR(200) NOT NULL,
    numero INT NOT NULL,
    colonia VARCHAR(200) NOT NULL,
    cp INT NOT NULL,
    referencias VARCHAR(200),
    PRIMARY KEY(id)

);

CREATE TABLE ClienteDireccion (

    clienteID UUID NOT NULL,
    direccionID UUID NOT NULL,
    FOREIGN KEY(clienteID) REFERENCES usuario (id) ON DELETE CASCADE,
    FOREIGN KEY(direccionID) REFERENCES direccion (id),
    PRIMARY KEY(clienteID, direccionID)

);