package com.revature.shoes.ui;

import com.revature.shoes.daos.ShoeDAO;
import com.revature.shoes.daos.UserDAO;
import com.revature.shoes.models.Shoe;
import com.revature.shoes.services.ShoeService;
import com.revature.shoes.services.UserService;

import java.util.Scanner;

public class AdminMenu implements Imenu {
    private final ShoeService shoeService;
    Shoe shoe = new Shoe();

    public AdminMenu(ShoeService shoeService) {
        this.shoeService = shoeService;
    }


    @Override
    public void start() {
        char input = ' ';
        boolean done = false;

        Scanner sc = new Scanner(System.in);

        while(!done) {
            System.out.println("\nAdmin Menu");
            System.out.println("\n(1) User Login ");
            System.out.println("(2) Add Shoe");
            System.out.println("(3) Order History");
            System.out.println("(4) Shoe Menu");
            System.out.println("(5) Leave Store");

            System.out.println("\nPlease make a selection:");

            input = sc.next().charAt(0);

            switch(input) {
                case '1':
                    UserDAO UserDAO = new UserDAO();
                    new LoginMenu(new UserService(UserDAO)).start();
                    break;
                case '2':
                    createShoe();
                    break;
                case '3':
                    break;
                case '4':
                    ShoeDAO ShoeDAO = new ShoeDAO();
                    new ShoeMenu(new ShoeService(ShoeDAO)).start();
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
        String shoe_brand = " ";
        String shoe_name = " ";
        String shoe_type = " ";
        int shoe_size = 0;
        String color = " ";
        int shoe_inventory = 0;
        double price = 0.0;

        Scanner sc1 = new Scanner(System.in);
        System.out.println("\nCreating Shoe...");

        while(true) {
            System.out.println("What is the Brand of Shoe?");
            shoe.setBrand(sc1.nextLine());

            System.out.println("What is the Name of the Shoe?");
            shoe.setName(sc1.nextLine());

            System.out.println("What is the Type of Shoe");
            shoe.setType(sc1.nextLine());

            System.out.println("What is the Shoe Size?");
            shoe.setSize(sc1.nextInt());
            sc1.nextLine();

            System.out.println("What is the color of the Shoe");
            shoe.setColor(sc1.nextLine());

            System.out.println("What is the current Inventory");
            shoe.setQty(sc1.nextInt());
            sc1.nextLine();

            System.out.println("What is the Price");
            shoe.setPrice(sc1.nextDouble());

            System.out.println(shoe);

            System.out.println("\nIs the Shoe Information Correct");

            if(sc1.next().charAt(0) == 'y') {

                shoeService.getShoeDao().save(shoe);

                new ShoeMenu(shoeService).start();
            }else{
                new ShoeMenu(shoeService).start();
            }
        }
    }

}
