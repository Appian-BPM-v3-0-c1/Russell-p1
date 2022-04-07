package com.revature.shoes.ui;



import com.revature.shoes.services.UserService;

import java.util.Scanner;

public class LoginMenu implements Imenu {
    private UserService userService;

    public LoginMenu(UserService userService) {
        this.userService = userService;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void start() {
        char input = ' ';
        boolean done = false;



        while (!done) {
            System.out.println("\n Kick's Member Login");
            System.out.println("[1] User Login");
            System.out.println("[2] Create new account");
            System.out.println("[3] Order History");
            System.out.println("[4] Exit Store");

            input = sc.next().charAt(0);

            switch (input) {
                case '1':
                    break;
                case '2':
                    createAccount();
                    break;
                case '3':
                    break;
                case '4':
                    done = true;
                    break;
                default:
                    System.out.println("\nIncorrect Entry....try again");
                    break;
            }
        }
    }
    private void createAccount() {
        String username = " ";
        String password = " ";



        System.out.println("\nCreating account... ");

        while (true) {
            System.out.print("\nEnter new UserName");

            username = sc.next();

            System.out.println(userService.isValidUsername(username));
        }
    }
}
