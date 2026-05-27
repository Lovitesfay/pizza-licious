package ui;

import models.DrinksAndChips;
import models.Order;
import models.Pizza;
import util.ReceiptWriter;

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
                    addPizza(new Order());
                    break;
                case 2:
                    addDrink(new Order());
                    break;
                case 3:
                    addChips(new Order());
                    break;
                case 4:
                    checkout(new Order());
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

    public void addPizza(Order order) {

        System.out.println("Hungry? we got pizza! ");

        System.out.print("Enter crust type: ");
        scanner.nextLine();
        String crust = scanner.nextLine();

        System.out.print("Enter pizza size: ");
        String size = scanner.nextLine();

        System.out.print("Enter base type: ");
        String base = scanner.nextLine();

        // create pizza
        Pizza pizza = new Pizza(crust, size, base);

        // add toppings
        System.out.print("Add meat: ");
        String meat = scanner.nextLine();
        pizza.addMeat(meat);

        System.out.print("Add cheese: ");
        String cheese = scanner.nextLine();
        pizza.addCheese(cheese);

        // add pizza to order
        order.addPizza(pizza);

        System.out.println("Pizza added!");

    }

    public void addDrink(Order order) {

        System.out.println("Thirsty? lets quench that thirst! ");
        System.out.println();

        System.out.print("[COOL DRINKS]");
        System.out.println();
        System.out.println("""
            Coke, Diet Coke, Pepsi
            Sprite, Dr Pepper, Mountain Dew
            Ozarka, Dasani, Aquafina""");

        System.out.print("choose your drink: ");
        String name = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter drink size: ");
        String size = scanner.nextLine();

        System.out.print("""
                  20 oz
                  1 liter
                  2 liters
                """);
        System.out.println("choose size: ");
        double drinkSize = scanner.nextDouble();


        scanner.nextLine();

        // create drink
        DrinksAndChips drink =
                new DrinksAndChips(name, size, drinkSize);

        // add to order
        order.addDrink(drink);

        System.out.println("Drink added!");


    }

    public void addChips(Order order) {

        System.out.println("Craving? we can satisfy you! ");
        System.out.println();
        System.out.print(" KETTLE CHIPS ");
        System.out.println();
        System.out.println("""
            Salt, BBQ, Jalapeño
            Vinegar, Pepper, Mustard
            Honey, Truffle, Habanero""");
        System.out.print("Choose your chips: ");
        String name = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter Chips size: ");
        String size = scanner.nextLine();
        System.out.print("Enter drink price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        DrinksAndChips chips =
                new DrinksAndChips(name, size, price);

        // add to order
        order.addChips(chips);

    }

    public void checkout(Order order) {
        System.out.println(" Lets get you out of here ");
        System.out.println("\n====== CHECKOUT ======");

        // show order
        System.out.println(order.getOrderSummary());

        // show total
        System.out.println("\nTotal: $" + order.getTotal());

        // save receipt
        ReceiptWriter.saveReceipt(order);

        System.out.println("Thank you for your order!");



    }

    public void cancelOrder() {
        System.out.println("Why are you going to cancel?.");


    }
}

