package com.revature.shoes.daos;

import java.util.List;

public interface CrudDAO <T> {
    T save(T obj);

    List<T> findAll();

    T findByID(String id);

    boolean update(T updateObj);

    boolean removeById(String id);
}
