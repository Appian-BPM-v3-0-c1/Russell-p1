package com.revature.shoes.ui;

import com.revature.shoes.daos.HistoryDAO;
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
                    viewHistory();
                    break;
                case '3':
                    viewCart();
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
                        Cart cart = new Cart();
                        cart.setShoe_id(thisShoe.getId());
                        cart.setUser_id(user.getId());
                        cart.setInventory_id(thisShoe.getId());
                        cartService.getCartDao().save(cart);

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

    private void viewHistory() {
        List<History> historyList = HistoryService.getHistoryDAO().findAll();

        for(History h : historyList) {
            System.out.println(ShoeService.getShoeDAO().findByID(h.getId()));
        }
    }

    private void viewCart() {
        List<Cart> carts = (List<Cart>) CartService.getCartDAO().findByID(user.getId());


        while(true) {
            for(Cart c : carts) {
                System.out.println(ShoeService.getShoeDAO().findByID(c.getId()));
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

        for(Cart c : carts) {
            history.setShoe_id(c.getShoe_id());
            history.setUser_id(c.getUser_id());
            history.setCart_id(c.getId());

            HistoryService.getHistoryDAO().save(history);

            ShoeService.getShoeDAO().removeByID(c.getUser_id());

        }
        System.out.println("Enjoy your Kick's....Checkout Complete");

        for (Cart c : carts) {
            CartService.getCartDAO().removeByID(c.getUser_id());
        }
    }
}