package com.example.demo.api;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/productos")
@RestController
public class ProductoController extends AbsController<Producto, UUID>{
    private  final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService)
    {
        super(productoService);
        this.productoService = productoService;
    }

    @PutMapping(path = "{id}")
    public void updateUsuario(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Producto usuario){
        productoService.update(id, usuario);
    }
}
