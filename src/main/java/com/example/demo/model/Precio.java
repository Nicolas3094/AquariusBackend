package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity(name="Precio")
@Table(name="PRECIO")
public class Precio {

    @Id
    @Column(
            name="id",
            updatable = false,
            insertable = false
    )
    @SequenceGenerator(
            name="precio_sequence",
            sequenceName = "precio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "precio_sequence"
    )
    private long id;

    @Column(
            name="tipo",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String tipo;

    @Column(
            name="valor_tipo"
    )


    private float value;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="prod_id", referencedColumnName = "prod_id", nullable = false, insertable = false, updatable = false)
    private Producto producto;

    public Precio(){}
    public Precio(String tipo, float value) {
        this.tipo = tipo;
        this.value=value;
    }
    public Precio(Producto producto, String tipo, float value) {
        this.producto = producto;
        this.tipo = tipo;
        this.value=value;
    }
    public long getId(){
        return id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public Producto getProducto() {
        return producto;
    }


    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
