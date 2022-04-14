package com.revature.shoes.services;

import com.revature.shoes.daos.CartDAO;
import com.revature.shoes.daos.CrudDAO;
import com.revature.shoes.models.Cart;
import com.revature.shoes.models.Shoe;

public class CartService {
    static CartDAO cartDAO = new CartDAO();

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }


    public static CartDAO getCartDAO() {
        return cartDAO;
    }

    public CrudDAO<Cart> getCartDao() {
        return null;
    }
}
