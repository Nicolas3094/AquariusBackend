CREATE TABLE usuario (
    id UUID NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    userName VARCHAR(100) NOT NULL,
    imagen VARCHAR(500) DEFAULT NULL,
    verificado INT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);

CREATE TABLE rol (
    id INT NOT NULL,
    tipo_rol VARCHAR(255) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE(tipo_rol)
);

CREATE TABLE marca (
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY(nombre)
);

CREATE TABLE producto (
    id UUID NOT NULL,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    cantidad INTEGER DEFAULT 0,
    n_marca VARCHAR(255) NOT NULL,
    imagen  VARCHAR DEFAULT NULL,
    descripcion  VARCHAR DEFAULT NULL,
    fecha DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY(id)
);

CREATE TABLE categoria (
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY(nombre)
);

CREATE TABLE precio (
     id INT NOT NULL,
     precio_tipo VARCHAR(100) NOT NULL,
     PRIMARY KEY (id),
     UNIQUE (precio_tipo)
);

CREATE TABLE pedido(
    numeroPedido INT NOT NULL,
    fecha DATE DEFAULT CURRENT_DATE,
    status_pedido VARCHAR(200) NOT NULL,
    PRIMARY KEY(numeroPedido)
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

CREATE TABLE articulo (
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

