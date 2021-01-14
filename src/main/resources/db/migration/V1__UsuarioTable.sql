CREATE TABLE usuario (
    id UUID NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    userName VARCHAR(100) NOT NULL,
    imagen VARCHAR(500),
    verificado INT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);

CREATE TABLE rol (
    id INT NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE usuarioRol (
    usuarioID UUID NOT NULL,
    tipoID INT NOT NULL,
    FOREIGN KEY(usuarioID) REFERENCES usuario (id) ON DELETE CASCADE,
    FOREIGN KEY(tipoID) REFERENCES rol (id) ON DELETE SET NULL,
    PRIMARY KEY(usuarioID, tipoID)
);

CREATE TABLE categoria (
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY(nombre)
);

CREATE TABLE marca (
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY(nombre)
);

CREATE TABLE producto (
    id UUID NOT NULL,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    cantidad INTEGER NOT NULL,
    n_marca VARCHAR(255) NOT NULL,
    imagen  VARCHAR(1500),
    descripcion  VARCHAR(1500),
    fecha DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY(n_marca) REFERENCES marca (nombre) ON DELETE SET NULL,
    PRIMARY KEY(id)
);

CREATE TABLE productoCategoria (
    prodctoID UUID NOT NULL,
    categoriaID VARCHAR(255) NOT NULL,
    FOREIGN KEY(prodctoID) REFERENCES producto (id) ON DELETE CASCADE,
    FOREIGN KEY(categoriaID) REFERENCES categoria (nombre) ON DELETE SET NULL,
    PRIMARY KEY(prodctoID, categoriaID)
);
CREATE TABLE precios (
     id INT NOT NULL,
     tipo VARCHAR(100) NOT NULL,
     PRIMARY KEY (id),
     UNIQUE (tipo)
 );


 CREATE TABLE productoPrecio(
     productoID UUID NOT NULL,
     precioID INT NOT NULL,
     precio DECIMAL(9,2) NOT NULL DEFAULT 0,
     FOREIGN KEY(productoID) REFERENCES producto (id) ON DELETE CASCADE,
     FOREIGN KEY(precioID) REFERENCES precios (id) ON DELETE SET NULL,
     PRIMARY KEY(productoID, precioID)
 );

INSERT INTO rol (id,tipo) VALUES (0,'ADMINISTRADOR');
INSERT INTO rol (id,tipo) VALUES (1,'CLIENTE');
INSERT INTO rol (id,tipo) VALUES (2,'EDITOR');
INSERT INTO rol (id,tipo) VALUES (3,'ANONIMO');

INSERT INTO precios (id, tipo) VALUES (0, 'PRINCIPAL');
INSERT INTO precios (id, tipo) VALUES (1, 'SECUNDARIO');
INSERT INTO precios (id, tipo) VALUES (2, 'OPCIONAL');