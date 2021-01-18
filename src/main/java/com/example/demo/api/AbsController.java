package com.example.demo.api;


import com.example.demo.model.Categoria;
import com.example.demo.service.AbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public abstract class AbsController<T,K> {
    private final AbsService<T,K> service;

    @Autowired
    protected AbsController(AbsService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity add(@RequestBody T obj){
        try{
            service.add(obj);
            return new ResponseEntity("Objeto creado", HttpStatus.CREATED);
        }catch (HttpClientErrorException e){
            return new ResponseEntity(e.getMessage(), e.getStatusCode());
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public T getUsuarios(@PathVariable("id") K id){
        return service.getObj(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<T> deleteUsuarioId(@PathVariable("id") K id){
        try {
            service.delete(id);
            return new ResponseEntity<T>(HttpStatus.ACCEPTED);
        }
        catch (HttpClientErrorException e){
            return new ResponseEntity("Error: "+e.getMessage(),e.getStatusCode());
        }
    }
}
