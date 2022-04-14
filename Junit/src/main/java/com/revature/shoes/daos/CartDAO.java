package com.revature.shoes.daos;

import com.revature.shoes.connection.DatabaseConnection;
import com.revature.shoes.models.Cart;
import com.revature.shoes.models.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements CrudDAO<Cart>{
    Connection con = new DatabaseConnection().getCon();

    @Override
    public void save(Cart obj) {
        try{
            PreparedStatement ps = con.prepareStatement("Insert into shoes (cart_id, shoe_id, user_id," +
                    " total_price) VALUES (?,?,?,?)");

            ps.setInt(1, obj.getCart_id());
            ps.setInt(2, obj.getShoe_id());
            ps.setInt(3, obj.getUser_id());
            ps.setDouble(4, obj.getTotal_price());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> findAll() {
        List<Cart> cartList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM shoes");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Cart cart = new Cart();

                cart.setShoe_id(rs.getInt("id"));
                cart.setUser_id(rs.getInt("user_id"));
                cart.setTotal_price(rs.getDouble("total_price"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public Cart findByID(int id) {
        return null;
    }

    @Override
    public Shoe findByID(String id) {
        return null;
    }

    @Override
    public boolean update(Cart updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
