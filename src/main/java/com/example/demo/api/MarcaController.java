package com.example.demo.api;

import com.example.demo.model.Marca;
import com.example.demo.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/marcas")
@RestController
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService userService) {
        this.marcaService = userService;
    }

    @PostMapping
    public void addUsuario(@Valid @NotNull @RequestBody Marca usuario){
        marcaService.add(usuario);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public List<Marca> getAllUsuarios(){
        return marcaService.getAll();
    }

    @GetMapping(path = "{nombre}")
    public Marca getUsuarios(@PathVariable("nombre") String nombre){
        return marcaService.getObj(nombre)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Marca> deleteUsuarioId(@PathVariable("id") String id){
        final int response = marcaService.delete(id);
        if(response==0){
            return new ResponseEntity<Marca>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Marca>(HttpStatus.ACCEPTED);
    }
}
