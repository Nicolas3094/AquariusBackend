package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Marca {
    @NotBlank
    private final String nombre;

    public Marca(@JsonProperty("nombre")String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
