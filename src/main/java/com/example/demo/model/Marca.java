package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MARCA")
public class Marca {

    @Id
    @Column(
            name="id_marca",
            updatable = false
    )
    private String nombre;

    @OneToMany(mappedBy = "marca")
    private List<Producto> productos;

    public  Marca(){}
    public Marca(String nombre){
        this.nombre = nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
