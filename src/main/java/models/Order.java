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

        // drinks
        for (DrinksAndKnots drink : drinks) {
            total += drink.getPrice();
        }

        // garlic knots / chips
        for (DrinksAndKnots knot : knots) {
            total += knot.getPrice();
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

    public ArrayList<DrinksAndKnots> getKnots() {
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
        summary += "Knots: " + knots + "\n";

        summary += "\nTotal: $" + getTotal();
        return summary;
    }
    public void cancelOrder() {

        pizzas.clear();
        drinks.clear();
        knots.clear();
    }


}
