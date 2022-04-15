package com.revature.shoes.services;


import com.revature.shoes.daos.ShoeDAO;


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



}
