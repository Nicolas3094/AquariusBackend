package com.example.demo.dao;

import com.example.demo.model.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioDAO {
    int insertUsuario(UUID id, Usuario usuario);

    default  int insertUsuario(Usuario usuario){
        UUID id = UUID.randomUUID();
        return insertUsuario(id, usuario);
    }
    List<Usuario> selectAllUsuarios();

    Optional<Usuario> selectUsuarioID(UUID id);

    int deleteUsuario(UUID id);

    int updateUsuario(UUID id, Usuario usuario);



}
