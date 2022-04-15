package com.revature.shoes.ui;

import com.revature.shoes.daos.LocationDAO;
import com.revature.shoes.daos.ShoeDAO;
import com.revature.shoes.daos.UserDAO;
import com.revature.shoes.models.Location;
import com.revature.shoes.models.Shoe;
import com.revature.shoes.models.User;
import com.revature.shoes.services.LocationService;
import com.revature.shoes.services.ShoeService;
import com.revature.shoes.services.UserService;

import java.util.Scanner;

public class AdminMenu implements Imenu {
    private final ShoeService shoeService;

    private final User user;



    public AdminMenu(ShoeService shoeService, User user) {

        this.shoeService = shoeService;
        this.user = user;

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
            System.out.println("(3) Add Location");
            System.out.println("(4) Order History");
            System.out.println("(5) Shoe Menu");
            System.out.println("(6) Leave Store");

            System.out.println("\nPlease make a selection:");

            input = sc.next().charAt(0);

            switch(input) {
                case '1':
                    new LoginMenu(new UserService(new UserDAO())).start();
                    break;
                case '2':
                    createShoe();
                    break;
                case '3':
                    createLocation();
                    break;
                case '4':
                    break;
                case '5':
                    new ShoeMenu(new ShoeService(new ShoeDAO())).start();
                    break;
                case '6':
                    done = true;
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
            }

        }
    }


    private void createShoe() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;

        Scanner sc1 = new Scanner(System.in);
        Shoe shoe = new Shoe();

        System.out.println("\nCreating Shoe...");
        System.out.println("What is the Brand of Shoe?");
        shoe.setBrand(sc1.nextLine());

        System.out.println("What is the Name of the Shoe?");
        shoe.setName(sc1.nextLine());
        /*while(true) {

            if (!shoeService.isDuplicate(shoe_name)) {

            } else {
                System.out.println("Invalid Shoe Name!!");
                break;
            }


        }*/
        while (!exit){
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



            while(!confirm) {


                System.out.println("\nIs the Shoe Information Correct");
                System.out.println(shoe);

                System.out.println("\nEnter y or n:");
                input = sc1.next().charAt(0);

                switch (input) {
                    case 'y':
                        //saves shoe to database
                        shoeService.getShoeDAO().save(shoe);
                        System.out.println("\nShoe Created!!");
                        exit = true;
                        new AdminMenu(new ShoeService(new ShoeDAO()), user).start();
                    case 'n':
                        createShoe();
                        break;
                    default:
                        System.out.println("Invalid....Try Again!");
                        break;
                }
            }
        }
    }

    private void createLocation(){
        Scanner sc = new Scanner(System.in);
        Location location = new Location();
        LocationService locationService = new LocationService(new LocationDAO());


        boolean confirm = false;
        char input = ' ';

        System.out.println("Enter Location Details....");
        location.setLocation(sc.next());

        System.out.println("Enter the Shoe Name....");
        location.setShoe_name(sc.next());

        System.out.println("Enter the Inventory Qty....");
        location.setInventory_qty(sc.nextInt());
        sc.nextLine();

        while(!confirm) {


            System.out.println("\nIs the Location Information Correct");
            System.out.println(location);

            System.out.println("\nEnter y or n:");
            input = sc.next().charAt(0);

            switch (input) {
                case 'y':
                    //saves location to database
                    locationService.getLocationDAO().save(location);
                    System.out.println("\nLocation Created!!");
                    confirm = true;
                    new AdminMenu(new ShoeService(new ShoeDAO()), user).start();
                case 'n':
                    createLocation();
                    break;
                default:
                    System.out.println("Invalid....Try Again!");
                    break;
            }
        }
    }

}
