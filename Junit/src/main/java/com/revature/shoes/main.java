package com.revature.shoes;

import com.revature.shoes.connection.DatabaseConnection;
import com.revature.shoes.daos.UserDAO;
import com.revature.shoes.services.UserService;
import com.revature.shoes.ui.MainMenu;


import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        new MainMenu(new UserService(new UserDAO())).start();

    }
}
