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
public class ProductoController {
    private  final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public void addUsuario(@Valid @NotNull @RequestBody Producto usuario){
        productoService.add(usuario);
    }

    @GetMapping
    public List<Producto> getAllUsuarios(){
        return productoService.getAll();
    }

    @GetMapping(path = "{id}")
    public Producto getUsuarios(@PathVariable("id") UUID id){
        return productoService.getID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Producto> deleteUsuarioId(@PathVariable("id") UUID id){
        final int response = productoService.delete(id);
        if(response==0){
            return new ResponseEntity<Producto>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<Producto>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "{id}")
    public void updateUsuario(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Producto usuario){
        productoService.update(id, usuario);
    }
}
