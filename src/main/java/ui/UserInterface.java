package ui;

import java.util.Scanner;

public class UserInterface {

    public void diplay(){}
    Scanner scanner = new Scanner(System.in);

    // constructor


    public void showHomeScreen() {
        System.out.println("""
                1) New Order
                0) Exit
                """);

        while (true) {
            switch (scanner.nextInt()) {

                case 1:
                    showOrderMenu();
                    break;
                case 0:
                    System.out.println("See you Soon!");
                    System.exit(0);
            }
        }
    }

    public void showOrderMenu() {
        System.out.println("""
         1) Add Pizza
         2) Add Drink
         3) Add Chips
         4) Checkout
         0) Cancel Order
                """);

        while (true) {

            switch (scanner.nextInt()) {
                case 1:
                    addPizza();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    cancelOrder();
                    System.out.println("Order has been cancelled.");
                    break;
                    default:
                        System.out.println("Invalid input!");


            }
        }
    }

    public void addPizza() {

        System.out.println("Hungry? we got pizza! ");

    }

    public void addDrink() {

        System.out.println("Thirsty? we got drink! ");

    }

    public void addChips() {

        System.out.println("Craving? we got chips! ");

    }

    public void checkout() {
        System.out.println(" Lets get you out of here ");

    }

    public void cancelOrder() {
        System.out.println("Why are you going to cancel?.");

    }
}

