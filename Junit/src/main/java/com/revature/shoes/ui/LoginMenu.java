package com.revature.shoes.ui;



import com.revature.shoes.models.User;
import com.revature.shoes.services.UserService;

import java.util.Scanner;

public class LoginMenu implements Imenu {
    private UserService userService;

    public LoginMenu(UserService userService) {
        this.userService = userService;
    }

    Scanner sc = new Scanner(System.in);
    User user = new User();

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
                    login();
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
        String userName = " ";
        String password = " ";
        String password2 = " ";
        String firstName = " ";
        String lastName = " ";
        String email = " ";
        int zipCode = 0;
        int shoeSize = 0;
        String favBrand = " ";

        boolean userOk = false;
        char input = ' ';

        System.out.println("\nCreating account... ");

        while (true) {
            while (true) {
                System.out.print("\nEnter new UserName");

                userName = sc.next();

                if (!userService.isDuplicate(userName)) {
                    if (userService.isValidUsername(userName)) {
                        user.setUserName(userName);

                        break;
                    } else {
                        System.out.println("Invalid Username!!");
                    }

                } else {
                    System.out.println("Duplicate Username!!!");
                }

            }


            while (true) {
                System.out.print("\nEnter in password: ");
                password = sc.next();

                System.out.print("\nEnter in password again: ");
                password2 = sc.next();

                if (password.equals(password2)) {
                    if (userService.isValidPassword(password)) {
                        user.setPassword(password);
                        break;
                    } else {
                        System.out.println("\nInvalid password!");
                    }
                } else {
                    System.out.println("Password does not match!");
                }
            }
            while (true) {
                System.out.println("\nNeed your personal information......");
                
                System.out.println("\nEnter your first name");
                user.setFirstName(sc.next());

                System.out.println("Enter you last name");
                user.setLastName(sc.next());

                System.out.println("Enter your email");
                user.setEmail(sc.next());

                System.out.println("Enter your Zip Code");
                user.setZipCode(sc.nextInt());

                System.out.println("Enter your Favorite Brand");
                user.setFavBrand(sc.next());


                System.out.println(user);

                System.out.println("\nIs your information correct??");

                if(sc.next().charAt(0) == 'y') {
                    System.out.println("\nPlease confirm credentials (y/n) ");
                    System.out.print("Username: " + userName);
                    System.out.print("\nPassword: " + password);

                    System.out.print("\nEnter: ");

                    if(sc.next().charAt(0) == 'y') {
                        userService.getUserDao().save(user);

                        System.out.println("User created successfully");
                        break;
                    } else {
                        createAccount();
                    }
                } else {
                    new OrderMenu().start();
                }
            }



        }

    }
    private void login() {
        while(true) {
            System.out.println("\nUsername: ");
            user.setUserName(sc.next());

            System.out.println("\nPassword: ");
            user.setPassword(sc.next());

            if (userService.isValidLogin(user)) {
                user.setId(userService.getUserDao().getId(user.getUserName()));
                new MainMenu(userService).start();
                break;
            } else {
                System.out.println("\nLogin Not Accepted");
            }
        }
    }
}