package com.example.demo.model;

public enum ROLE {
    ADMINISTRADOR("ADMINISTRADOR"),
    CLIENTE("CLIENTE"),
    ANONIMO("ANONIMO"),
    EDITOR("EDITOR");
    private String actual;

    private ROLE(String tipo){
        if(tipo=="ADMINISTRADOR" || tipo=="CLIENTE" || tipo == "ANONIMO" || tipo == "EDITOR"){
            actual=tipo;
        }else{
            throw new Error("Error no se admite diferente actual");
        }
    }
    @Override
    public String toString() {
        return actual;
    }



}
