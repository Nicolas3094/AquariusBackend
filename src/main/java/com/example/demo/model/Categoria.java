package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Categoria {

    @NotBlank
    private final String nombre;

    public Categoria(@JsonProperty("nombre")String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
