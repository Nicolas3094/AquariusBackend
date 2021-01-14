package com.example.demo.service;

import com.example.demo.dao.ProductoDAO;

import com.example.demo.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductoService {
    private final ProductoDAO productoDAO;

    @Autowired
    public ProductoService(@Qualifier("producto") ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public int add(Producto producto){
        return productoDAO.insert(producto);
    }
    public List<Producto> getAll(){
        return productoDAO.selectAll();
    }
    public Optional<Producto> getID(UUID id){
        return productoDAO.selectID(id);
    }

    public int delete(UUID id){
        return productoDAO.deleteID(id);
    }
    public int update(UUID id, Producto producto){
        return productoDAO.updateID(id, producto);
    }

}
