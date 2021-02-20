package com.example.demo.model;

public enum TIPO_PRECIO {
    PRINCIPAL("PRINCIPAL"),
    SECUNDARIO("SECUNDARIO"),
    OPCIONAL("OPCIONAL");
    private String actual;

    private TIPO_PRECIO(String tipo){
        if(tipo=="PRINCIPAL" || tipo=="SECUNDARIO" || tipo == "OPCIONAL"){
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
