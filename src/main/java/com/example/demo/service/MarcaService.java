package com.example.demo.service;

import com.example.demo.dao.marca.MarcaDAO;
import com.example.demo.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService extends AbsService<Marca, String>{

    private final MarcaDAO catdao;

    @Autowired
    public MarcaService(MarcaDAO catdao){
        super(catdao);
        this.catdao = catdao;
    }

    @Override
    protected String createID(Marca obj) {
        return obj.getNombre();
    }
}
