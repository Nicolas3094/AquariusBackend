package com.example.demo.api;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.UUID;

@RequestMapping("api/v1/usuarios")
@RestController
public class UsuarioController {
    private  final UsuarioService userService;

    @Autowired
    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUsuario(@Valid @NotNull @RequestBody Usuario usuario){
        userService.addUsuario(usuario);
    }

    @GetMapping
    public String getAllUsuarios(){
        return "<h1>hola mundo</h1>";
    }

    @GetMapping(path = "{id}")
    public Usuario getUsuarios(@PathVariable("id") UUID id){
        return userService.getUsurio(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Usuario> deleteUsuarioId(@PathVariable("id") UUID id){
        final int response = userService.deleteUsuario(id);
        if(response==0){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "{id}")
    public void updateUsuario(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Usuario usuario){
        userService.updateUsuario(id, usuario);
    }


}
