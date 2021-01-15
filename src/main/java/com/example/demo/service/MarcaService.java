package com.example.demo.service;

import com.example.demo.dao.MarcaDAO;
import com.example.demo.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaDAO catdao;

    @Autowired
    public MarcaService(MarcaDAO catdao){
        this.catdao = catdao;
    }
    public int add(Marca cat){
        return catdao.insert(cat);
    }
    public List<Marca> getAll(){
        return catdao.selectAll();
    }
    public Optional<Marca> getObj(String id){
        return catdao.selectID(id);
    }

    public int delete(String id){
        return catdao.deleteID(id);
    }
}
