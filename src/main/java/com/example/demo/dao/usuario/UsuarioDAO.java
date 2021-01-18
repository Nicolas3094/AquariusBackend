package com.example.demo.dao.usuario;

import com.example.demo.dao.DAO;
import com.example.demo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioDAO extends DAO<Usuario, UUID> {

}
