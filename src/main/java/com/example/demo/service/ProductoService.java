package com.example.demo.service;

import com.example.demo.dao.precio.precioRep;
import com.example.demo.dao.producto.ProductoDAO;

import com.example.demo.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductoService extends AbsService<Producto,UUID>{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoDAO rep;
    private final precioRep precio;

    @Autowired
    public ProductoService(ProductoDAO rep, precioRep precio) {
        super(rep);
        this.rep=rep;
        this.precio=precio;
    }

    public void update(UUID id, Producto producto){
        if(rep.existsById(id)){
            rep.save(new Producto(
                    id,
                   producto.getNombre(),
                    (int) producto.getCantidad(),
                    producto.getDescripcion(),
                    producto.getImage(),
                    producto.getFecha()
            ));
        }
    }

    @Override
    public void add(Producto obj){
        UUID id = createID(obj);
        if(rep.existsById(id)){
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"Objeto creado previamente.");
        }else {
            rep.save(obj);

        }
    }
    @Override
    protected UUID createID(Producto obj) {
        final UUID id = UUID.randomUUID();
        obj.setId(id);
        return id;
    }

    @Async
    private CompletableFuture<Producto> analyzePrecios(Producto precios){
        precios.getPrecios().forEach(x->{
            x.setProducto(precios);
        });
        precios.getPrecios().forEach(x->{
            precio.save(new Precio(x.getTipo(), x.getValue()));
        });
        return CompletableFuture.completedFuture(precios);
    }
}
