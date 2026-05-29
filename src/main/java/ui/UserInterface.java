package ui;

import models.DrinksAndKnots;
import models.Order;
import models.Pizza;
import util.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {

    public void diplay() {
    }
            // user input
    Scanner scanner = new Scanner(System.in);

    // first screen
    public void showHomeScreen() {

        while (true) {

            // option for user
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
            // user will order here
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
                    return;
                case 0:
                    cancelOrder(order);
                    return;

                default:
                    System.out.println("Invalid input!");


            }
        }
    }

    public void addPizza(Order order) {

        System.out.println(" ");

        System.out.println("""
            =====================
                   PIZZA
            =====================

            1) Build Your Own Pizza
            2) Margherita
            3) Veggie
            """);

        System.out.print("Choose pizza: ");
        int pizzaChoice = scanner.nextInt();
        scanner.nextLine();

        // MARGHERITA
        if (pizzaChoice == 2) {

            System.out.println("""
                Sizes:
                8 inch
                12 inch
                16 inch
                """);

            System.out.print("Choose size: ");
            String size = scanner.nextLine();

            Pizza margherita =
                    new Pizza("Regular", true, size, "Marinara");

            margherita.addCheese("Mozzarella");
            margherita.addToppings("Tomatoes");
            margherita.addToppings("Basil");
            margherita.addToppings("Olive Oil");

            order.addPizza(margherita);

            System.out.println("Margherita Pizza added!");
            System.out.println();
            return;
        }

        // VEGGIE
        if (pizzaChoice == 3) {

            System.out.println("""
                Sizes:
                8 inch
                12 inch
                16 inch
                """);

            System.out.print("Choose size: ");
            String size = scanner.nextLine();

            Pizza veggie =
                    new Pizza("Regular", true,  size, "Marinara");

            veggie.addCheese("Mozzarella");

            veggie.addToppings("Bell Peppers");
            veggie.addToppings("Spinach");
            veggie.addToppings("Onions");

            order.addPizza(veggie);

            System.out.println("Veggie Pizza added!");
            return;
        }



        // build your own pizza
        System.out.println("""
                Crust Types:
                1) Thin Crust
                2) Regular Crust
                3) Thick Crust
                4) Cauliflower Crust
                """);

        System.out.print("choose crust: ");
        String crust = scanner.nextLine();

        // stuffed crust
        System.out.print("Would you like stuffed crust? yes/no: ");
        String stuffedAnswer = scanner.nextLine();

        boolean stuffedCrust = false;

        if (stuffedAnswer.equalsIgnoreCase("yes")) {
            stuffedCrust = true;
            System.out.println("Stuffed crust added!");
        }

            // size
            System.out.println("""
                    Pizza Sizes:
                    8 inch
                    12 inch
                    16 inch
                    """);


            System.out.print("choose size: ");
            String size = scanner.nextLine();

            String sauce = "";

            // create pizza
            Pizza pizza = new Pizza(crust, stuffedCrust, size, sauce);

            while (true) {
                // sauce
                System.out.println("""
                        Sauces:
                        Marinara 
                        Alfredo 
                        Pesto 
                        BBQ 
                        Buffalo 
                        Olive oil
                        """);

                System.out.print("Choose sauce: ");
                sauce = scanner.nextLine();

                pizza.addSauce(sauce);

                System.out.print("Add another sauce? yes/no: ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("no")) {
                    break;
                }
            }


            // meats
            System.out.println("""
                    Meats:
                    Pepperoni
                    Sausage
                    Ham
                    Bacon
                    Chicken
                    Meatball
                    
                    """);

            // meat choice
            System.out.print("add meat: ");
            String meat = scanner.nextLine();

            double price = 0;

            if (!meat.equalsIgnoreCase("none")) {

                pizza.addMeat(meat);

                if (size.equalsIgnoreCase("8 inch")) {
                    price += 1.00;
                } else if (size.equalsIgnoreCase("12 inch")) {
                    price += 2.00;
                } else if (size.equalsIgnoreCase("16 inch")) {
                    price += 3.00;
                }
            }

            while (true) {

                System.out.print("Would you like extra meat? yes/no: ");
                String extraMeat = scanner.nextLine();

                if (extraMeat.trim().equalsIgnoreCase("no")) {
                    break;
                }

                System.out.println("""
                        Extra Meat Choices:
                        Pepperoni
                        Sausage
                        Ham
                        Bacon
                        Chicken
                        Meatball
                        """);

                System.out.print("Choose extra meat: ");
                String extraChoice = scanner.nextLine();

                pizza.addMeat(extraChoice);

                System.out.println(extraChoice + " added!");
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
                } else if (size.equals("12")) {
                    price += 1.50;
                } else if (size.equals("16")) {
                    price += 2.25;
                }
            }

            // extra cheese
            while (true) {

                System.out.print("Would you like extra cheese? yes/no: ");
                String extraCheese = scanner.nextLine();

                if (extraCheese.trim().equalsIgnoreCase("no")) {
                    break;
                }

                System.out.println("""
                        Extra Cheese Choices:
                        Mozzarella
                        Parmesan
                        Ricotta
                        Goat Cheese
                        Buffalo
                        """);

                System.out.print("Choose extra cheese: ");
                String extraChoice = scanner.nextLine();

                pizza.addCheese(extraChoice);

                // extra cheese pricing
                if (size.equalsIgnoreCase("8 inch")) {
                    price += .30;
                } else if (size.equalsIgnoreCase("12 inch")) {
                    price += .60;
                } else if (size.equalsIgnoreCase("16 inch")) {
                    price += .90;
                }

                System.out.println(extraChoice + " added!");
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

            // extra toppings
            while (true) {

                System.out.print("Would you like extra toppings? yes/no: ");
                String extraTopping = scanner.nextLine();

                if (extraTopping.equalsIgnoreCase("no")) {
                    break;
                }

                System.out.println("""
                        Topping Choices:
                        Onions
                        Mushrooms
                        Bell Peppers
                        Olives
                        Tomatoes
                        Spinach
                        Basil
                        Pineapple
                        Anchovies
                        """);

                System.out.print("Choose topping: ");
                String toppingChoice = scanner.nextLine();

                pizza.addToppings(toppingChoice);

                // toppings are free
                System.out.println(toppingChoice + " added!");
            }


            // add to order
            order.addPizza(pizza);

            System.out.println();
            System.out.println("Pizza added!");
        }


     public void addDrink(Order order) {


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
                  Meduim
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

        System.out.println("drink added!");
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
        System.out.println("=====================");
        System.out.println("      CHECKOUT");
        System.out.println("=====================");

// pizzas
        System.out.println("\nPIZZAS");
        System.out.println("---------------------");

        for (Pizza pizza : order.getPizzas()) {
            System.out.println(pizza);
        }

// drinks
        System.out.println("\nDRINKS");
        System.out.println("---------------------");

        for (DrinksAndKnots drink : order.getDrinks()) {
            System.out.println(drink);
        }

// knots
        System.out.println("\nGARLIC KNOTS");
        System.out.println("---------------------");

        for (DrinksAndKnots knot : order.getKnots()) {
            System.out.println(knot);
        }

        System.out.println("---------------------");
        System.out.println("TOTAL: $" + order.getTotal());

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
            System.out.println();

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

