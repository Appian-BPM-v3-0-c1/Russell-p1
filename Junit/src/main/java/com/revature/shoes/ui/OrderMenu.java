package com.revature.shoes.ui;

import com.revature.shoes.daos.CartDAO;
import com.revature.shoes.daos.HistoryDAO;
import com.revature.shoes.daos.ShoeDAO;
import com.revature.shoes.models.Cart;
import com.revature.shoes.models.History;
import com.revature.shoes.models.Shoe;
import com.revature.shoes.models.User;
import com.revature.shoes.services.CartService;
import com.revature.shoes.services.HistoryService;
import com.revature.shoes.services.ShoeService;

import java.util.List;
import java.util.Scanner;

public class OrderMenu implements Imenu {
    private final User user;



    public OrderMenu(User user) {
        this.user = user;


    }

    @Override
    public void start() {
        char input = ' ';
        boolean done = false;
        Scanner sc = new Scanner(System.in);

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
                    viewHistory();
                    break;
                case '3':
                    viewCart();
                    break;
                case '4':

                    new ShoeMenu(new ShoeService(new ShoeDAO())).start();
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
        ShoeService shoeService = new ShoeService(new ShoeDAO());
        Scanner sc = new Scanner(System.in);
        List<Shoe> shoeList = shoeService.getShoeDAO().findAll();
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
        Scanner sc = new Scanner(System.in);
        CartService cartService = new CartService(new CartDAO());

        while (!tr) {
            System.out.println("What Shoe do you want, enter a number matching the ID");
            input = sc.nextInt();

            if (input < shoeList.size()) {
                Shoe thisShoe = shoeList.get(input);
                System.out.println("add to your cart?");

                if (sc.nextLine().charAt(0) == 'y') {
                    if (thisShoe.getQty() < 0) {
                        Cart cart = new Cart();
                        cart.setShoe_id(thisShoe.getId());
                        cart.setUser_id(user.getId());
                        cart.setInventory_id(thisShoe.getId());
                        cartService.getCartDAO().save(cart);

                        System.out.println("Item added to Cart");
                        break;
                    } else if (thisShoe.getQty() >= 0) {
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

    private void viewHistory() {
        ShoeService shoeService = new ShoeService(new ShoeDAO());
        HistoryService historyService = new HistoryService(new HistoryDAO());


        List<History> historyList = historyService.getHistoryDAO().findAll();

        for(History h : historyList) {
            System.out.println(shoeService.getShoeDAO().findByID(h.getId()));
        }
    }

    private void viewCart() {
        ShoeService shoeService = new ShoeService(new ShoeDAO());
        CartService cartService = new CartService(new CartDAO());

        Scanner sc = new Scanner(System.in);
        List<Cart> carts = (List<Cart>) cartService.getCartDAO().findByID(user.getId());


        while(true) {
            for(Cart c : carts) {
                System.out.println(shoeService.getShoeDAO().findByID(c.getId()));
            }

            System.out.println("Checkout??");

            if(sc.nextLine().charAt(0) == 'y') {
                checkOut( carts);
                break;
            }
        }
    }

    private void checkOut(List<Cart> carts) {
        History history = new History();
        HistoryService historyService = new HistoryService(new HistoryDAO());
        ShoeService shoeService = new ShoeService(new ShoeDAO());
        CartService cartService = new CartService(new CartDAO());

        for(Cart c : carts) {
            history.setShoe_id(c.getShoe_id());
            history.setUser_id(c.getUser_id());
            history.setCart_id(c.getId());

            historyService.getHistoryDAO().save(history);

            shoeService.getShoeDAO().removeByID(c.getUser_id());

        }
        System.out.println("Enjoy your Kick's....Checkout Complete");

        for (Cart c : carts) {
            cartService.getCartDAO().removeByID(c.getUser_id());
        }
    }
}