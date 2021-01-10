package com.example.demo.dao;

import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UsuarioDataAccessService implements UsuarioDAO{

    private final JdbcTemplate jdbctemplate;

    @Autowired
    public UsuarioDataAccessService(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    @Override
    public int insertUsuario(UUID id, Usuario usuario) {
        return jdbctemplate.update("INSERT INTO usuario (id, nombre) VALUES (?,?)", id, usuario.getNombre());
    }

    @Override
    public List<Usuario> selectAllUsuarios() {
        return jdbctemplate.query("SELECT id,nombre FROM usuario", (resultSet, i) -> {
            return new Usuario(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("nombre"));
        });
    }

    @Override
    public Optional<Usuario> selectUsuarioID(UUID id) {
        Usuario user =  jdbctemplate.queryForObject("SELECT id,nombre FROM usuario WHERE id = ?",
                new Object[]{id},
                (resultSet, i) -> {
            return new Usuario(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("nombre"));
        });
        return Optional.ofNullable(user);
    }

    @Override
    public int deleteUsuario(UUID id) {
        return jdbctemplate.update("DELETE FROM usuario WHERE id=?", id);
    }

    @Override
    public int updateUsuario(UUID id, Usuario usuario) {
        return jdbctemplate.update("UPDATE usuario SET nombre=? WHERE id=?", usuario.getNombre(), id);
    }
}
