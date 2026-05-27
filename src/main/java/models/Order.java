package models;

import java.util.ArrayList;

public class Order {

    // arraylist
    private ArrayList<Pizza> pizzas;
    private ArrayList<DrinksAndChips> drinks;
    private ArrayList<DrinksAndChips> chips;

    // constructor
    public Order() {
        pizzas = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();

    }

    // methods
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDrink(DrinksAndChips drink) {
        drinks.add(drink);
    }

    public void addChips(DrinksAndChips chip) {
        chips.add(chip);

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

    public ArrayList<DrinksAndChips> getDrinks() {
        return drinks;
    }

    public ArrayList<DrinksAndChips> getChips() {
        return chips;
    }

    // Order Summary
    public String getOrderSummary(){
        String summary = "";

        summary += "Pizzas:\n";

        for(Pizza pizza : pizzas) {
            summary += pizza.getSummary() + "\n";
        }

        summary += "\nDrinks: " + drinks + "\n";
        summary += "Chips: " + chips + "\n";

        summary += "\nTotal: $" + getTotal();
        return summary;
    }
}
