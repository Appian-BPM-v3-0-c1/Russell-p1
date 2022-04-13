package com.revature.shoes.services;

import com.revature.shoes.daos.CartDAO;

public class CartService {
    CartDAO cartDAO = new CartDAO();

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }


}
