package com.revature.shoes.ui;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ShoeMenu implements Imenu {


    @Override
    public void start() {
        char input = ' ';
        boolean done = false;

        Scanner sc = new Scanner(System.in);

        while(!done) {
            System.out.println("\nSneakers, Kicks, and Nike's");
            System.out.println("\n(1) Sneakers by Brand");
            System.out.println("(2) Sneakers by Size");
            System.out.println("(3) Add Shoe to Cart");
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

    private void createShoe() {
        System.out.println("\nCreating Shoe...");
    }
}

