package com.example.demo.model;

public class Precio {

    private final int id;

    private final TIPO_PRECIO tipo;

    public Precio(int id, TIPO_PRECIO tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo.toString();
    }
}
