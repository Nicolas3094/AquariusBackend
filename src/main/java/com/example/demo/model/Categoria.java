package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="CATEGORIA")
public class Categoria {

    @Id
    @Column(
            name="id_categoria",
            updatable = false
    )
    private String nombre;

    public Categoria(){

    }
    public Categoria(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}
