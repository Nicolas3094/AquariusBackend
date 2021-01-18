package com.example.demo.api;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.UUID;

@RequestMapping("api/v1/usuarios")
@RestController
public class UsuarioController extends AbsController<Usuario, UUID>{
    private  final UsuarioService userService;

    @Autowired
    public UsuarioController(UsuarioService userService) {

        super(userService);
        this.userService = userService;
    }

    @PutMapping(path = "{id}")
    public void updateUsuario(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Usuario usuario){
        userService.updateUsuario(id, usuario);
    }


}
