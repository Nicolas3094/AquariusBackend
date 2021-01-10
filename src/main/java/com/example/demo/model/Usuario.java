package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Usuario {

    private final UUID id;

    @NotBlank
    private  final String nombre;


    public Usuario(
            @JsonProperty("id") UUID id,
            @JsonProperty("nombre") String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
