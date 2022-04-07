package com.revature.shoes.ui;

import com.revature.shoes.models.User;
import com.revature.shoes.services.UserService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class UserMenu implements Imenu {

    @Override
    public void start() {
        char input = ' ';
        boolean done = false;

        Scanner sc = new Scanner(System.in);

        while(!done) {
            System.out.println("\nUser/Login Menu");
            System.out.println("\n(1) User Login ");
            System.out.println("(2) Add Customer");
            System.out.println("(3) Checkout");
            System.out.println("(4) Shoe Menu");
            System.out.println("(5) Leave Store");

            System.out.println("\nPlease make a selection:");

            input = sc.next().charAt(0);

            switch(input) {
                case '1':
                new LoginMenu(new UserService()).start();
                    break;
                case '2':
                    createUser();
                    break;
                case '3':
                    break;
                case '4':
                    new ShoeMenu().start();
                    break;
                case '5':
                    done = true;
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
            }

        }
    }
    private void createUser() {

        char input = ' ';
        Scanner  sc1 = new Scanner(System.in);
        User user_1 = new User();
        boolean exit = false;
        boolean userOk = false;

        while (!exit) {
            System.out.println("\nGetting Ready to Create New User......");
            System.out.println("Enter User ID");
            user_1.getId(sc1.nextInt());

            System.out.println("\nEnter your first name");
            user_1.setFirstName(sc1.next());

            System.out.println("Enter you last name");
            user_1.setLastName(sc1.next());

            System.out.println("Enter your email");
            user_1.setEmail(sc1.next());

            System.out.println("Enter your Zip Code");
            user_1.setZipCode(sc1.nextInt());

            System.out.println("Enter your Shoe Size");
            user_1.setShoeSize(sc1.nextInt());

            System.out.println("Enter your Favorite Brand");
            user_1.setFavBrand(sc1.next());

            System.out.println("Enter your Username");
            user_1.setUserName(sc1.next());

            while (!userOk) {
                System.out.println("Is the information entered correct? [y/n]");
                System.out.println(user_1);

                input = sc1.next().charAt(0);

                switch (input) {
                    case 'y':
                        System.out.println("User Created...Go find some Kick's");
                        userOk = true;
                        exit = true;
                        break;
                    case 'n':
                        userOk = true;
                        break;
                    default:
                        System.out.println("\nIncorrect Input Try Again");
                        break;
                }
            }
        }
    }

}
