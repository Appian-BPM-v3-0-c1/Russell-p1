package com.revature.shoes.connection;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection {
    /*Instantiating connection object*/
    private static Connection con = null;

    /*Instantiating properties object to retrieve properties variables */
    private static final Properties prop = new Properties();

    static {
        try {
            /*importing the jdbc jar file into jvm*/
            Class.forName("org.postgresql.Driver");

            /*Using prop object to load url*/
            prop.load(new FileReader("C:\\Users\\rande\\Revature\\project1\\Russell-p1\\Junit\\src\\main\\resources\\db.properties"));

            /*making connection with con and info given in db properties */
            con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

            /* Throw exception if connection was not successful */
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    /*Getter for connection*/
    public static Connection getCon() {
        return con;
    }
}
