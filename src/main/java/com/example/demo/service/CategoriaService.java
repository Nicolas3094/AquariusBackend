package com.example.demo.service;

import com.example.demo.dao.CategoriaDAO;
import com.example.demo.model.Categoria;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaDAO catdao;

    @Autowired
    public CategoriaService(CategoriaDAO catdao){
        this.catdao = catdao;
    }
    public int add(Categoria cat){
        return catdao.insert(cat);
    }
    public List<Categoria> getAll(){
        return catdao.selectAll();
    }
    public Optional<Categoria> getObj(String id){
        return catdao.selectID(id);
    }

    public int delete(String id){
        return catdao.deleteID(id);
    }
}
