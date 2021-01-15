package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K >{
    int insert( T obj);

    List<T> selectAll();

    Optional<T> selectID(K id);

    int deleteID(K id);

    int updateID(K id, T obj);
}
