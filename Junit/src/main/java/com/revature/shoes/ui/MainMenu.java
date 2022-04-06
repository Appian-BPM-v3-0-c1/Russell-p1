package com.revature.shoes.ui;

import java.util.Scanner;

public class MainMenu implements Imenu {
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
                    new ShoeMenu().start();
                    break;
                case '2':
                    break;
                case '3':
                    new UserMenu().start();
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
