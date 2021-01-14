package com.example.demo.dao;

import com.example.demo.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class MarcaDataAccessService implements  MarcaDAO{

    private final JdbcTemplate jdbctemplate;

    @Autowired
    public MarcaDataAccessService(JdbcTemplate jdbctemplate){
        this.jdbctemplate = jdbctemplate;
    }

    @Override
    public int insert( Marca obj) {
        return jdbctemplate.update("INSERT INTO marca VALUES (?)", obj.getNombre());
    }

    @Override
    public List<Marca> selectAll() {
        return jdbctemplate.query("SELECT nombre FROM marca", (resultSet,i)->{
            return new Marca(resultSet.getString("nombre"));
        });
    }

    @Override
    public Optional<Marca> selectID(String id) {
        Marca brand = jdbctemplate.query("SELECT nombre FROM marca WHERE nombre='"+id+"'", rs -> {
            rs.next();
            return new Marca(rs.getString("nombre"));
        });
        return Optional.ofNullable(brand);
    }

    @Override
    public int deleteID(String id) {
        return jdbctemplate.update("DELETE FROM marca WHERE nombre=?", id);
    }

    @Override
    public int updateID(String id, Marca obj) {
        return jdbctemplate.update("UPDATE marca SET nombre=? WHERE id=?", obj.getNombre(), id);
    }
}
