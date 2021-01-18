package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="USUARIO")
public class Usuario {

    @Id
    @Column(
            updatable = false
    )
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String nombre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String apellido;

    @Column(
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private  String displayName;

    private  String imagen;

    @Column(nullable = false)
    private  String contraseña;

    @Column( nullable = false)
    private  short verificado;

    @Column( nullable = false)
    private  String rol;

    public Usuario(){}

    public Usuario(
             UUID id,
            String nombre,
            String apellido,
            String displayName,
             String imagen,
           String contraseña,
            short verificado,
            String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.displayName = displayName;
        this.imagen = imagen;
        this.contraseña = contraseña;
        this.verificado = verificado;
        this.rol = rol;
    }

    public void setId(UUID id){
        this.id = this.id==null? id : throw_();
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
        return displayName;
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
    public UUID throw_() {
        throw new RuntimeException("id is already set");
    }

}
