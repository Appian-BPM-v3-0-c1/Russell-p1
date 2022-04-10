package com.revature.shoes.services;

import com.revature.shoes.daos.UserDAO;
import com.revature.shoes.models.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public UserDAO getUserDao() {
        return userDAO;
    }

    public boolean isDuplicate(String userName){
        List<String> userName_list = userDAO.findAllUserNames();

        for(String i : userName_list) {
            if( i.equals(userName)) {
                return true;
            }
        }

        return false;
    }


    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }

    public boolean isValidLogin(User user) {
        List<User> userList = userDAO.findAll();

        for (User u : userList) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }

        return false;
    }
}
