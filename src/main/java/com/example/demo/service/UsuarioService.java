package com.example.demo.service;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioDAO userdao;

    @Autowired
    public UsuarioService(@Qualifier("postgres") UsuarioDAO userdao) {
        this.userdao = userdao;
    }

    public int addUsuario(Usuario user){
        return userdao.insertUsuario(user);
    }
    public List<Usuario> getAllUsuarios(){
        return userdao.selectAllUsuarios();
    }
    public Optional<Usuario> getUsurio(UUID id){
        return userdao.selectUsuarioID(id);
    }

    public int deleteUsuario(UUID id){
        return userdao.deleteUsuario(id);
    }
    public int updateUsuario(UUID id, Usuario usuario){
        return userdao.updateUsuario(id, usuario);
    }



}
