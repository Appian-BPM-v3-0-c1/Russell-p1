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
            PreparedStatement ps = con.prepareStatement("Insert into carts (shoe_id, user_id," +
                    " inventory_id) VALUES (?,?,?)");


            ps.setInt(1, obj.getShoe_id());
            ps.setInt(2, obj.getUser_id());
            ps.setInt(3, obj.getInventory_id());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> findAll() {
        List<Cart> cartList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM carts");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setShoe_id(rs.getInt("shoe_id"));
                cart.setUser_id(rs.getInt("user_id"));
                cart.setInventory_id(rs.getInt("inventory_id"));
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

    @Override
    public boolean removeByID(int id) {
        return false;
    }


    private  List<Cart> findByBrand(String brand) {
        return null;
    }


    private List<Cart> findBySize(int id) {
        return null;
    }


}
