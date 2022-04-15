package com.revature.shoes.services;

import com.revature.shoes.daos.CartDAO;




public class CartService {
   private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }


    public CartDAO getCartDAO() {
        return cartDAO;
    }
}
