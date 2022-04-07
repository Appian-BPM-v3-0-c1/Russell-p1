package com.revature.shoes.services;

import com.revature.shoes.daos.UserDAO;

public class UserService {
    private final UserDAO userDao;

    public UserService(UserDAO userDAO){
        this.userDao = userDAO;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public boolean isDuplicate(String username){

    }


    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }


}
