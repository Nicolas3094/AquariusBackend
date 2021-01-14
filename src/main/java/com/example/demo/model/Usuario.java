package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Usuario {

    private final UUID id;

    @NotBlank
    private final String nombre;

    @NotBlank
    private final String apellido;

    @NotBlank
    private final String userName;

    private final String imagen;

    @NotBlank
    private final String contraseña;

    private final short verificado;

    private final String rol;

    public Usuario(
            @JsonProperty("id") UUID id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("apellido") String apellido,
            @JsonProperty("username") String userName,
            @JsonProperty("imagen") String imagen,
            @JsonProperty("contraseña") String contraseña,
            short verificado,
            String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.userName = userName;
        this.imagen = imagen;
        this.contraseña = contraseña;
        this.verificado = verificado;
        this.rol = rol;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUserName() {
        return userName;
    }

    public String getImagen() {
        return imagen;
    }

    public String getContraseña() {
        return contraseña;
    }

    public short isVerificado() {
        return verificado;
    }


    public String getRol() {
        return rol;
    }
}
