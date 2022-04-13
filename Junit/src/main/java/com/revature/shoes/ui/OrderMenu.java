package com.revature.shoes.ui;

import com.revature.shoes.services.ShoeService;

import java.util.Scanner;

public class OrderMenu implements Imenu {
    @Override
    public void start() {
        char input = ' ';
        boolean done = false;

        Scanner sc = new Scanner(System.in);

        while(!done) {
            System.out.println("\nOrder/Checkout Menu");
            System.out.println("\n(1) View Order");
            System.out.println("(2) Add/Delete from Order");
            System.out.println("(3) Checkout");
            System.out.println("(4) Shoe Menu");
            System.out.println("(5) Leave Store");

            System.out.println("\nPlease make a selection:");

            input = sc.next().charAt(0);

            switch(input) {
                case '1':

                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    ShoeService shoeService = null;
                    new ShoeMenu(shoeService).start();
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
