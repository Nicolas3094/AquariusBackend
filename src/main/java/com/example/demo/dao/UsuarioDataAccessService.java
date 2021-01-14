package com.example.demo.dao;

import com.example.demo.model.ROLE;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UsuarioDataAccessService implements UsuarioDAO{

    private final String attrs = "id, verificado, nombre, apellido, contraseña, username, imagen";

    private final JdbcTemplate jdbctemplate;

    @Autowired
    public UsuarioDataAccessService(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    int getRole(String roleName){
        return jdbctemplate.query("SELECT id FROM rol WHERE tipo='"+roleName+"'",rs -> {
            rs.next();
            return rs.getInt("id");
        });
    }
    String getRoleName(UUID id){
        int rolID= jdbctemplate.query("SELECT tipoid FROM usuariorol WHERE usuarioid='"+id+"'", rs -> {
            rs.next();
            return rs.getInt("tipoid");
        });
        return jdbctemplate.query("SELECT tipo FROM rol WHERE id='"+rolID+"'", rs -> {
            rs.next();
            return rs.getString("tipo");
        });
    }
    @Override
    public int insert(Usuario usuario) {
        UUID id = UUID.randomUUID();
        int  rol = getRole("CLIENTE");
        int resp= jdbctemplate.update("INSERT INTO usuario ("+attrs+") VALUES (?,?,?,?,?,?)",
                id, 0,usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getUserName(), usuario.getImagen()
        );
        if(resp==0){
            return 0;
        }
        return jdbctemplate.update("INSERT INTO usuariorol (usuarioid, tipoid) VALUES (?,?)",
                id, rol);

    }

    @Override
    public List<Usuario> selectAll() {
        return jdbctemplate.query("SELECT "+attrs+" FROM usuario", (resultSet, i) -> {
            final String rol = getRoleName(UUID.fromString(resultSet.getString("id")));
            return new Usuario(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("username"),
                    resultSet.getString("imagen"),
                    resultSet.getString("contraseña"),
                    (short) resultSet.getInt("verificado"),
                    rol);
        });
    }

    @Override
    public Optional<Usuario> selectID(UUID id) {
        Usuario user =  jdbctemplate.query("SELECT "+attrs+" FROM usuario WHERE id = ?",
                (resultSet) -> {
            resultSet.next();
            return new Usuario(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("username"),
                    resultSet.getString("imagen"),
                    resultSet.getString("contraseña"),
                    (short) resultSet.getInt("verificado"),
                    getRoleName(UUID.fromString(resultSet.getString("id"))));
        });
        return Optional.ofNullable(user);
    }

    @Override
    public int deleteID(UUID id) {
        return jdbctemplate.update("DELETE FROM usuario WHERE id=?", id);
    }

    @Override
    public int updateID(UUID id, Usuario usuario) {
        return jdbctemplate.update("UPDATE usuario SET nombre=? WHERE id=?", usuario.getNombre(), id);
    }
}
