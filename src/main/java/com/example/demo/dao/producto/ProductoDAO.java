package com.example.demo.dao.producto;

import com.example.demo.dao.DAO;
import com.example.demo.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ProductoDAO  extends DAO<Producto, UUID> {

}
