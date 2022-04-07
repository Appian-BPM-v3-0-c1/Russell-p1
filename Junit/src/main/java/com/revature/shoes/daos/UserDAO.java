package com.revature.shoes.daos;


import com.revature.shoes.models.User;

import java.util.List;

public class UserDAO implements CrudDAO<User>{
    @Override
    public User save(User obj) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByID(String id) {
        return null;
    }

    @Override
    public boolean update(User updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
