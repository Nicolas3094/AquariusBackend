package com.example.demo.service;

import com.example.demo.dao.DAO;
import com.example.demo.dao.categoria.CategoriaDAO;
import com.example.demo.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends AbsService<Categoria, String>{

    private final CategoriaDAO repository;

    @Autowired
    public CategoriaService(CategoriaDAO repository) {
        super(repository);
        this.repository=repository;

    }
    @Override
    protected String createID(Categoria categoria) {
        return categoria.getNombre();
    }
}
