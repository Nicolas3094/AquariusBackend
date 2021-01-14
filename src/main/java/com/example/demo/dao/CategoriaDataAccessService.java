package com.example.demo.dao;

import com.example.demo.model.Categoria;
import com.example.demo.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaDataAccessService implements CategoriaDAO{

    private final JdbcTemplate jdbctemplate;
    private final String tablename = "categoria";

    @Autowired
    public CategoriaDataAccessService(JdbcTemplate jdbctemplate){
        this.jdbctemplate = jdbctemplate;
    }

    @Override
    public int insert( Categoria obj) {
        return jdbctemplate.update("INSERT INTO categoria VALUES (?)", obj.getNombre());
    }

    @Override
    public List<Categoria> selectAll() {
        return jdbctemplate.query("SELECT nombre FROM categoria", (resultSet,i)->{
            return new Categoria(resultSet.getString("nombre"));
        });
    }

    @Override
    public Optional<Categoria> selectID(String id) {
        Categoria brand = jdbctemplate.query("SELECT nombre FROM categoria WHERE nombre='"+id+"'", rs -> {
            rs.next();
            return new Categoria(rs.getString("nombre"));
        });
        return Optional.ofNullable(brand);
    }

    @Override
    public int deleteID(String id) {
        return jdbctemplate.update("DELETE FROM categoria WHERE nombre=?", id);
    }

    @Override
    public int updateID(String id, Categoria obj) {
        return jdbctemplate.update("UPDATE categoria SET nombre=? WHERE id=?", obj.getNombre(), id);
    }
}
