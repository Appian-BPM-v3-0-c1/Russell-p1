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

        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
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
          PreparedStatement ps = con.prepareStatement("SELECT (userName) FROM user");
          ResultSet rs = ps.executeQuery();

          while (rs.next()) {
              username_list.add(rs.getString("userName"));
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return username_list;
    }
}
