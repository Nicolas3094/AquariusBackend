package com.example.demo.api;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/categorias")
@RestController
public class CategoriaController extends AbsController<Categoria, String>{
    private final CategoriaService marcaService;

    @Autowired
    public CategoriaController(CategoriaService marcaService) {
        super(marcaService);
        this.marcaService = marcaService;
    }



}
