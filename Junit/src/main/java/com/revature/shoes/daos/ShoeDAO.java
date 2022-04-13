package com.revature.shoes.daos;

import com.revature.shoes.connection.DatabaseConnection;
import com.revature.shoes.models.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoeDAO implements CrudDAO<Shoe>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Shoe obj) {
        try{
            PreparedStatement ps = con.prepareStatement("Insert into shoes (shoe_brand, shoe_name, shoe_type," +
                    " shoe_size, color, shoe_inventory, price) VALUES (?,?,?,?,?,?,?)");

            ps.setString(1, obj.getBrand());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getType());
            ps.setInt(4, obj.getSize());
            ps.setString(5, obj.getColor());
            ps.setInt(6, obj.getQty());
            ps.setDouble(7, obj.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Shoe> findAll() {
        List<Shoe> shoeList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shoes");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Shoe shoe = new Shoe();

                shoe.setId(rs.getInt("shoe_id"));
                shoe.setBrand(rs.getString("shoe_brand"));
                shoe.setName(rs.getString("shoe_name"));
                shoe.setType(rs.getString("shoe_type"));
                shoe.setSize(rs.getInt("shoe_size"));
                shoe.setColor(rs.getString("color"));
                shoe.setQty(rs.getInt("shoe_inventory"));
                shoe.setPrice(rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoeList;
    }

    @Override
    public Shoe findByID(int id) {
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

    public List<String> findAllShoes() {
        List<String> shoe_name_list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (shoe_name) From shoes");
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoe_name_list;
    }

    public List<Shoe> findByBrand(String brand) {
        List<Shoe> shoes = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shoes where shoe_brand LIKE ?");
            ps.setString(1, "%" + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Shoe shoe = new Shoe();


                shoe.setBrand(rs.getString("shoe_brand"));
                shoe.setName(rs.getString("shoe_name"));
                shoe.setType(rs.getString("shoe_type"));
                shoe.setSize(rs.getInt("shoe_size"));
                shoe.setColor(rs.getString("color"));
                shoe.setQty(rs.getInt("shoe_inventory"));
                shoe.setPrice(rs.getDouble("price"));

                shoes.add(shoe);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return shoes;
    }
}
