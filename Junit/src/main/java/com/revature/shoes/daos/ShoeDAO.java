package com.revature.shoes.daos;

import com.revature.shoes.models.Shoe;

import java.util.List;

public class ShoeDAO implements CrudDAO<Shoe>{
    @Override
    public Shoe save(Shoe obj) {
        return null;
    }

    @Override
    public List<Shoe> findAll() {
        return null;
    }

    @Override
    public Shoe findByID(String id) {
        return null;
    }

    @Override
    public boolean update(Shoe updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
