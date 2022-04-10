package com.revature.shoes.daos;


import com.revature.shoes.connection.DatabaseConnection;
import com.revature.shoes.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public User save(User obj) {
        User User = null;
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (user_id, user_name, password, " +
                    "firstName, lastName, email, zipCode, fav_Brand )  VALUES");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getUserName());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getFirstName());
            ps.setString(4, obj.getLastName());
            ps.setString(5, obj.getEmail());
            ps.setInt(6, obj.getZipCode());
            ps.setString(7, obj.getFavBrand());
            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }




    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();


                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setZipCode(rs.getInt("zipCode"));
                user.setFavBrand(rs.getString("fav_brand"));

                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
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

    public List<String> findAllUserNames() {
        List<String> username_list = new ArrayList<>();

      try {
          PreparedStatement ps = con.prepareStatement("SELECT (user_name) FROM user");
          ResultSet rs = ps.executeQuery();

          while (rs.next()) {
              username_list.add(rs.getString("user_name"));
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return username_list;
    }
}
