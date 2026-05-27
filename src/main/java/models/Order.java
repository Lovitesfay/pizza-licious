package models;

import java.util.ArrayList;

public class Order {

    // arraylist
    private ArrayList<Pizza> pizzas;
    private ArrayList<DrinksAndKnots> drinks;
    private ArrayList<DrinksAndKnots> knots;

    // constructor
    public Order() {
        pizzas = new ArrayList<>();
        drinks = new ArrayList<>();
        knots = new ArrayList<>();

    }

    // methods
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDrink(DrinksAndKnots drink) {
        drinks.add(drink);
    }

    public void addKnot(DrinksAndKnots knot) {
        knots.add(knot);

    }

    //total
    public double getTotal() {

        double total = 0;

        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }

        return total;
    }

    // getters
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public ArrayList<DrinksAndKnots> getDrinks() {
        return drinks;
    }

    public ArrayList<DrinksAndKnots> getChips() {
        return knots;
    }

    // Order Summary
    public String getOrderSummary(){
        String summary = "";

        summary += "Pizzas:\n";

        for(Pizza pizza : pizzas) {
            summary += pizza.getSummary() + "\n";
        }

        summary += "\nDrinks: " + drinks + "\n";
        summary += "Chips: " + knots + "\n";

        summary += "\nTotal: $" + getTotal();
        return summary;
    }
    public void cancelOrder() {

        pizzas.clear();
        drinks.clear();
        knots.clear();
    }


}
