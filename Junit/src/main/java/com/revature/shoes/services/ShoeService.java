package com.revature.shoes.services;

import com.revature.shoes.daos.CrudDAO;
import com.revature.shoes.daos.ShoeDAO;
import com.revature.shoes.models.Shoe;

import java.util.List;

public class ShoeService {
    private final ShoeDAO shoeDAO;

    public ShoeService(ShoeDAO shoeDAO) {
        this.shoeDAO = shoeDAO;
    }

    public ShoeDAO getShoeDAO() {
        return shoeDAO;
    }

    public boolean isDuplicate(String shoe_name) {
        List<String> shoe_name_list = shoeDAO.findAllShoes();

        for (String i : shoe_name_list) {
            if (i.equals(shoe_name)) {
                return true;
            }
        }
        return false;
    }

    public CrudDAO<Shoe> getShoeDao() {
        CrudDAO<Shoe> ShoeDAO = null;
        return ShoeDAO;
    }
}