package com.revature.shoes.ui;

import com.revature.shoes.models.Cart;
import com.revature.shoes.models.Shoe;
import com.revature.shoes.models.User;
import com.revature.shoes.services.CartService;
import com.revature.shoes.services.ShoeService;

import java.util.List;
import java.util.Scanner;

public class OrderMenu implements Imenu {
    private final User user;

    Scanner sc = new Scanner(System.in);

    private CartService cartService;



    public OrderMenu(User user) {

        this.user = user;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean done = false;


        while (!done) {
            System.out.println("\nOrder/Checkout Menu");
            System.out.println("\n(1) Show Shoes to Buy");
            System.out.println("(2) Order History");
            System.out.println("(3) View/Checkout");
            System.out.println("(4) Shoe Menu");
            System.out.println("(5) Leave Store");

            System.out.println("\nPlease make a selection:");

            input = sc.next().charAt(0);

            switch (input) {
                case '1':
                    showItems();
                    break;
                case '2':
                    //viewHistory();
                    break;
                case '3':
                    //viewCart();
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

    private void showItems() {
        List<Shoe> shoeList = ShoeService.getShoeDAO().findAll();
        for (Shoe i : shoeList) {
            System.out.println(i);
        }
        System.out.println("Would you like to purchase Shoes?");
        if (sc.next().charAt(0) == 'y') {
            buyItems(shoeList);
        } else {
            System.out.println("Invalid Key Pressed...Try Again");
        }
    }

    private void buyItems(List<Shoe> shoeList) {
        int input = 0;
        boolean tr = false;

        while (!tr) {
            System.out.println("What Shoe do you want, enter a number matching the ID");
            input = sc.nextInt();

            if (input > shoeList.size()) {
                Shoe thisShoe = shoeList.get(input);
                System.out.println("add to your cart?");

                if (sc.nextLine().charAt(0) == 'y') {
                    if (thisShoe.getQty() < 0) {
                        Cart newCart = new Cart();
                        newCart.setShoe_id(thisShoe.getId());
                        newCart.setUser_id(user.getId());
                        newCart.setTotal_price(thisShoe.getPrice());
                        cartService.getCartDao().save(newCart);

                        System.out.println("Item added to Cart");
                        break;
                    } else if (thisShoe.getQty() == 0) {
                        System.out.println("Item not in stock");
                        break;
                    } else if (sc.nextLine().charAt(0) == 'n') {
                        break;
                    } else {
                        System.out.println("Invalid Entry...Try Again");
                        break;
                    }
                }
            } else {
                System.out.println("Invalid Entry...Try Again ");
                break;
            }

        }
    }

    /*private void viewHistory() {
        List<History> historyList = historyService.getHistoryDAO
    }*/
}