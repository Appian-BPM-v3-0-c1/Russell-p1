package com.revature.shoes.daos;


import com.revature.shoes.connection.DatabaseConnection;
import com.revature.shoes.models.Shoe;
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
    public void save(User obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users ( user_name, password, " +
                    "firstName, lastName, email, zipCode)  VALUES (?,?,?,?,?,?)");

            ps.setString(1, obj.getUserName());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getFirstName());
            ps.setString(4, obj.getLastName());
            ps.setString(5, obj.getEmail());
            ps.setInt(6, obj.getZipCode());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();


                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setZipCode(rs.getInt("zipCode"));


                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public Shoe findByID(String id) {
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

    @Override
    public boolean removeByID(int id) {
        return false;
    }



    public List<String> findAllUserNames() {
        List<String> username_list = new ArrayList<>();

      try {
          PreparedStatement ps = con.prepareStatement("SELECT (user_name) FROM users");
          ResultSet rs = ps.executeQuery();

          while (rs.next()) {
              username_list.add(rs.getString("user_name"));
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return username_list;
    }

    public int getId(String userName) {
        return 0;
    }
}
