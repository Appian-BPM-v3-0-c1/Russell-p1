package com.revature.shoes.ui;

import com.revature.shoes.daos.ShoeDAO;
import com.revature.shoes.services.ShoeService;
import com.revature.shoes.services.UserService;

import java.util.Scanner;

public class MainMenu implements Imenu {

    public MainMenu(UserService userService) {
    }

    @Override
    public void start() {
        char input = ' ';
        boolean done = false;

        Scanner sc = new Scanner(System.in);

        while(!done) {
            System.out.println("\nSneakers, Kicks, and Nike's");
            System.out.println("\n(1) Buy some Kick's");
            System.out.println("(2) Search Sneakers");
            System.out.println("(3) User Support");
            System.out.println("(4) Checkout");
            System.out.println("(5) Leave Store");

            System.out.println("\nPlease make a selection:");

            input = sc.next().charAt(0);

            switch(input) {
                case '1':
                    ShoeDAO ShoeDAO = new ShoeDAO();
                    new ShoeMenu(new ShoeService(ShoeDAO)).start();
                    break;
                case '2':
                    new ShoeDAO().findAllShoes();
                    break;
                case '3':
                    ShoeService shoeService = null;
                    new AdminMenu(shoeService).start();
                    break;
                case '4':
                    new OrderMenu().start();
                    break;
                case '5':
                done = true;
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
            }
        }
    }
}
