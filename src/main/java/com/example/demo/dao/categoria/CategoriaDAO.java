package com.example.demo.dao.categoria;

import com.example.demo.dao.DAO;
import com.example.demo.model.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDAO extends DAO<Categoria, String> {
}
