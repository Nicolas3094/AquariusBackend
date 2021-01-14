package com.example.demo.dao;

import com.example.demo.model.Producto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductoDAO  {
    int insert( Producto obj);

    List<Producto> selectAll();

    Optional<Producto> selectID(UUID id);

    int deleteID(UUID id);

    int updateID(UUID id, Producto obj);
}
