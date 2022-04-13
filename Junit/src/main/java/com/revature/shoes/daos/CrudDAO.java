package com.revature.shoes.daos;

import com.revature.shoes.models.Shoe;

import java.util.List;

public interface CrudDAO <T> {
    void save(T obj);

    List<T> findAll();

    T findByID(int id);

    Shoe findByID(String id);

    boolean update(T updateObj);

    boolean removeById(String id);
}
