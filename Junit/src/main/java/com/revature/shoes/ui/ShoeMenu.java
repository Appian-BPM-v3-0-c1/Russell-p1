package com.revature.shoes.ui;

import com.revature.shoes.models.Shoe;
import com.revature.shoes.models.User;
import com.revature.shoes.services.ShoeService;
import com.revature.shoes.daos.ShoeDAO;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ShoeMenu implements Imenu {
    private final ShoeService shoeService;


    public ShoeMenu(ShoeService shoeService) {
        this.shoeService = shoeService;

    }

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
                    searchByBrand();
                    break;
                case '2':
                    //searchByID();
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
    public void searchByBrand() {
        String brand = " ";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSearch by Brand:  ");
            brand = sc.nextLine().toLowerCase();

            List<Shoe> shoes = shoeService.getShoeDAO().findByBrand(brand);

            if (shoes.isEmpty()) {
                System.out.println("\nInvalid Brand");
            } else {
                for (Shoe sh : shoes) {
                    System.out.println(sh);
                }
            }
        }
    }

    /*public void searchByID() {
        int id = 0;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\nSearch by ID:  ");
            id = sc.nextInt();

            List<Shoe> shoes = shoeService.getShoeDao().findByID(id);
            if(shoes.isEmpty()) {
                System.out.println("\nInvalid Size");
            } else {
                for (Shoe sh : shoes) {
                    System.out.println(sh);
                }
            }
        }
    }*/
}
