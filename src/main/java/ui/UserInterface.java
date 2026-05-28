package ui;

import models.DrinksAndKnots;
import models.Order;
import models.Pizza;
import util.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {

    public void diplay() {
    }

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
                1) thin
                2) regular
                3) thick
                4) cauliflower
                """);

        System.out.print("Select crust: ");
        int crustChoice = scanner.nextInt();
        scanner.nextLine();

        String crust = "";

        switch (crustChoice) {

            case 1:
                crust = "Thin Crust";
                break;

            case 2:
                crust = "Regular Crust";
                break;

            case 3:
                crust = "Thick Crust";
                break;
            case 4:
                crust = "Cauliflower Crust";
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        // size
        System.out.println("""
                Pizza Sizes:
                1) 8 inch
                2) 12 inch
                3) 16 inch
                """);

        System.out.print("Select size: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        String size = "";

        switch (sizeChoice) {

            case 1:
                size = "8";
                break;

            case 2:
                size = "12";
                break;

            case 3:
                size = "16";
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid choice!");
                return;
        }


        // sauce
        System.out.println("""
                Sauces:
                1) Marinara 
                2) Alfredo 
                3) Pesto 
                4) BBQ 
                5) Buffalo 
                6) Olive oil
                """);

        System.out.print("Select sauce: ");
        int sauceChoice = scanner.nextInt();
        scanner.nextLine();

        String sauce = "";

        switch (sauceChoice) {

            case 1:
                sauce = "Marinara";
                break;
            case 2:
                sauce = "Alfredo";
                break;
            case 3:
                sauce = "Pesto";
                break;
            case 4:
                sauce = "BBQ";
                break;
            case 5:
                sauce = "Buffalo";
                break;
            case 6:
                sauce = "Olive oil";
                break;
            case 0:
                return;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        // create pizza
        Pizza pizza = new Pizza(crust, size, sauce);

        // meats
        System.out.println("""
                Meats:
                1) Pepperoni
                2) Sausage
                3) Ham
                3) Bacon
                4) Chicken
                5) Meatball
                
                """);

        // meat choice
        System.out.print("add meat: ");
        String meat = scanner.nextLine();

        double price = 0;

        if (!meat.equalsIgnoreCase("none")) {

            pizza.addMeat(meat);

            if (size.equals("8")) {
                price += 1.00;
            } else if (size.equals("12")) {
                price += 2.00;
            } else if (size.equals("16")) {
                price += 3.00;
            }
        }

        // extra meat
        System.out.print("Extra meat? yes/no: ");
        String extraMeat = scanner.nextLine();

        if (extraMeat.equalsIgnoreCase("yes")) {

            if (size.equals("8")) {
                price += .50;
            }
            else if (size.equals("12")) {
                price += 1.00;
            }
            else if (size.equals("16")) {
                price += 1.50;
            }
        }


        // cheese
        System.out.println("""
                Cheese:
                Mozzarella
                Parmesan
                Ricotta
                Goat Cheese
                Buffalo
                """);

        // cheese
        System.out.print("select cheese: ");
        String cheese = scanner.nextLine();


        if (!cheese.equalsIgnoreCase("none")) {

            pizza.addCheese(cheese);

            if (size.equals("8")) {
                price += .75;
            }
            else if (size.equals("12")) {
                price += 1.50;
            }
            else if (size.equals("16")) {
                price += 2.25;
            }
        }

        // toppings
        System.out.println("""
                Toppings:
                onions
                mushrooms
                bell peppers
                olives
                tomatoes
                spinach
                basil
                pineapple
                anchovies
                
                """);


        // toppings
        System.out.print("add toppings: ");
        String topping = scanner.nextLine();
        pizza.addToppings(topping);


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
                  Small
                  Middle
                  Large
                """);

        System.out.print("choose size: ");
        String drinkSize = scanner.nextLine();
        System.out.println();

        // calculate price
        double drinkPrice = 0;


        if (drinkSize.equalsIgnoreCase("small")) {
            drinkPrice = 2.00;
        } else if (drinkSize.equalsIgnoreCase("meduim")) {
            drinkPrice = 2.50;
        } else if (drinkSize.equalsIgnoreCase("large")) {
            drinkPrice = 3.00;
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
        } else {

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

