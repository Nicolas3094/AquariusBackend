package com.example.demo.api;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/categorias")
@RestController
public class CategoriaController {
    private final CategoriaService marcaService;

    @Autowired
    public CategoriaController(CategoriaService userService) {
        this.marcaService = userService;
    }

    @PostMapping
    public void addUsuario(@Valid @NotNull @RequestBody Categoria usuario){
        marcaService.add(usuario);
    }

    @GetMapping
    public List<Categoria> getAllUsuarios(){
        return marcaService.getAll();
    }

    @GetMapping(path = "{id}")
    public Categoria getUsuarios(@PathVariable("id") String id){
        return marcaService.getObj(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Categoria> deleteUsuarioId(@PathVariable("id") String id){
        final int response = marcaService.delete(id);
        if(response==0){
            return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Categoria>(HttpStatus.ACCEPTED);
    }
}
