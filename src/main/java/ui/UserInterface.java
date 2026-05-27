package ui;

import models.DrinksAndKnots;
import models.Order;
import models.Pizza;
import util.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {

    public void diplay(){}
    Scanner scanner = new Scanner(System.in);

    // constructor


    public void showHomeScreen() {


        while (true) {

            System.out.println("""
                1) New Order
                0) Exit
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

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

         Order order = new Order();


        while (true) {

            System.out.println("""
         1) Add Pizza
         2) Add Drink
         3) Add Garlic Knots
         4) Checkout
         0) Cancel Order
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPizza(order);
                    break;
                case 2:
                    addDrink(order);
                    break;
                case 3:
                    addKnot(order);
                    break;
                case 4:
                    checkout(order);
                    break;
                case 0:
                    cancelOrder(order);
                    return;

                    default:
                        System.out.println("Invalid input!");


            }
        }
    }

    public void addPizza(Order order) {

        System.out.println("Hungry? we got pizza! ");

        System.out.println("""
            =====================
                   PIZZA
            =====================
            """);

        // crust
        System.out.println("""
            Crust Types:
            Thin
            Hand Tossed
            Deep Dish
            """);

        System.out.print("Select crust: ");
        String crust = scanner.nextLine();

        // size
        System.out.println("""
            Sizes:
            Small
            Medium
            Large
            """);

        System.out.print("Select size: ");
        String size = scanner.nextLine();

        // sauce
        System.out.println("""
            Sauces:
            Tomato
            Alfredo
            BBQ
            """);

        System.out.print("Select sauce: ");
        String sauce = scanner.nextLine();

        // create pizza
        Pizza pizza = new Pizza(crust, size, sauce);

        // meat
        System.out.print("Add meat: ");
        String meat = scanner.nextLine();
        pizza.addMeat(meat);

        // cheese
        System.out.print("Add cheese: ");
        String cheese = scanner.nextLine();
        pizza.addCheese(cheese);

        // toppings
        System.out.print("Add toppings: ");
        String topping = scanner.nextLine();
        pizza.addToppings(topping);

        // stuffed crust
        System.out.print("Stuffed crust? (yes/no): ");


        // add to order
        order.addPizza(pizza);

        System.out.println();
        System.out.println("Pizza added!");
    }

    public void addDrink(Order order) {

        System.out.println("Thirsty? lets quench that thirst! ");
        System.out.println();

        System.out.print("[  COLD DRINKS  ]");
        System.out.println();
        System.out.println("""
            Coke, Diet Coke, Pepsi
            Sprite, Dr Pepper, Mountain Dew
            Ozarka, Dasani, Aquafina""");

        System.out.print("choose your drink: ");
        String drinkName = scanner.nextLine();

        System.out.println("""
                  20 oz
                  1 liter
                  2 liters
                """);
        System.out.print("choose size: ");
        String drinkSize = scanner.nextLine();
        System.out.println();

        // calculate price
        double drinkPrice = 0;


        if (drinkSize.equalsIgnoreCase("20oz")) {
            drinkPrice = 2.00;
        }
        else if (drinkSize.equalsIgnoreCase("1ltr")) {
            drinkPrice = 3.00;
        }
        else if (drinkSize.equalsIgnoreCase("2ltr")) {
            drinkPrice = 4.00;
        }


        // create drink
        DrinksAndKnots drink =
                new DrinksAndKnots(drinkName, drinkSize, drinkPrice);

        // add to order
        order.addDrink(drink);

        System.out.println(drinkSize + " " + drinkName + " " + "$" + drinkPrice);
        System.out.println();





    }

    public void addKnot(Order order) {



        double price = 1.50;

        DrinksAndKnots knots =
                new DrinksAndKnots(
                        "Garlic Knots",
                        "Small",
                        price
                );

        order.addKnot(knots);

        System.out.println("Garlic Knots $" + price);
        System.out.println();

    }

    public void checkout(Order order) {
        System.out.println("""
            =====================
                  CHECKOUT
            =====================
            """);

        // show order details
        System.out.println(order.getOrderSummary());

        // show total
        System.out.println("Total: $" + order.getTotal());

        System.out.println("""
            1) Confirm
            0) Cancel
            """);

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {

            ReceiptWriter.saveReceipt(order);

            System.out.println("Receipt saved!");
            System.out.println("Thank you!");

            showHomeScreen();
        }
        else {

            order.cancelOrder();

            System.out.println("Order cancelled.");

        }

    }

    public void cancelOrder(Order order) {
        System.out.println("Would you like to cancel this order?.");
        System.out.println("Yes or no");
        scanner.nextLine();
        if (scanner.nextLine().equals("Yes")) {
            order.cancelOrder();
            System.out.println("Order cancelled!");
        }






    }
}

