package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class Producto {
    private final UUID id;

    @NotNull
    private final String nombre;

    @NotNull
    private final long cantidad;

    private final float[] precio;

    @NotNull
    private final String descripcion;

    private final String image;

    private final String fecha;

    @NotNull
    private final Marca marca;

    @NotNull
    private final List<Categoria> categorias;

    public Producto(
            @JsonProperty("id") UUID id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("cantidad") int cantidad,
            @JsonProperty("precio") float[] precio,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("imagen") String image,
            @JsonProperty("fecha") String fecha,
            @JsonProperty("marca") Marca marca,
            @JsonProperty("categorias") List<Categoria> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.image = image;
        this.fecha = fecha;
        this.marca = marca;
        this.categorias = categorias;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCantidad() {
        return cantidad;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getImage() {
        return image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float[] getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }
}
