package com.example.demo.service;

import com.example.demo.dao.usuario.UsuarioDAO;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class UsuarioService extends AbsService<Usuario, UUID>{

    private final UsuarioDAO userdao;

    @Autowired
    public UsuarioService(UsuarioDAO userdao) {
        super(userdao);
        this.userdao = userdao;
    }

    public void updateUsuario(UUID id, Usuario usuario){
        if(userdao.existsById(id)){
            userdao.save(new Usuario(
                    id,
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getUserName(),
                    usuario.getImagen(),
                    usuario.getContraseña(),
                    (short) 0,
                    "User"
                    ));
        }else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"No existe objeto.");
        }

    }


    @Override
    protected UUID createID(Usuario obj) {
        final UUID id = UUID.randomUUID();
        obj.setId(id);
        return id;
    }
}
