package com.example.demo.service;

import com.example.demo.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

public abstract class AbsService<T,K > {

    private final DAO<T, K > repository;

    @Autowired
    public AbsService(DAO<T, K > repository){
        this.repository=repository;
    }

    public void add(T obj){
        K id = createID(obj);
        if(repository.existsById(id)){
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"Objeto creado previamente.");
        }else {
            repository.save(obj);
        }
    }

    public List<T> getAll(){
        return repository.findAll();
    }
    public Optional<T> getObj(K id){
        if(repository.existsById(id)){
            return repository.findById(id);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Objeto no encontrado.");
    }

    public void delete(K id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Objeto no encontrado.");
        }
    }
    protected abstract K createID(T obj);


}
