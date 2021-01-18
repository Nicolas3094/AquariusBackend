package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@Entity(name="producto")
@Table(name="PRODUCTO")
public class Producto {

    @Id
    @Column(
            name="prod_id",
            updatable = false
    )
    private UUID id;

    @NotNull
    private String nombre;

    @NotNull
    private long cantidad;

    private String descripcion;

    private String image;

    private String fecha;

    @OneToMany
    private List<Precio> precios;

    @ManyToOne
    private Marca marca;

    @ManyToMany
    @JoinColumn(name="prod_id")
    private List<Categoria> categorias;

    public Producto(){
    }

    public Producto(
           UUID id,
           String nombre,
           int cantidad,
           String descripcion,
           String image,
            String fecha

           ) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.image = image;
        this.fecha = fecha;
    }



    public  List<Categoria> getCategorias(){
        return categorias;
    }
    public Marca getMarca(){
        return this.marca;
    }
    public void setId(UUID id){
         this.id= this.id==null?id : throw_();
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
    public String getImage() {
        return image;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public UUID throw_() {
        throw new RuntimeException("id is already set");
    }


    public  List<Precio> getPrecios(){
        return precios;
    }
}
