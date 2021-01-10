package com.example.demo.api;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
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
    public List<Usuario> getAllUsuarios(){
        return userService.getAllUsuarios();
    }

    @GetMapping(path = "{id}")
    public Usuario getUsuarios(@PathVariable("id") UUID id){
        return userService.getUsurio(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public  void deleteUsuarioId(@PathVariable("id") UUID id){
        userService.deleteUsuario(id);
    }

    @PutMapping(path = "{id}")
    public void updateUsuario(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Usuario usuario){
    userService.updateUsuario(id, usuario);
    }


}
