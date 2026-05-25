package models;

import java.util.ArrayList;

public class Order {

    public String pizzas;
    public String drinks;
    public String chips;

    // constructor
    public Order(String pizzas, String drinks, String chips) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.chips = chips;
    }

    public String addPizza(){
        return pizzas;
    }
    public String addDrink(){
        return drinks;
    }
    public String addChips(){
        return chips;
    }

    public double getTotal(){
        return 0;

    }

    public String getPizzas() {
        return pizzas;
    }

    public String getDrinks() {
        return drinks;
    }

    public String getChips() {
        return chips;
    }

    public String getOrderSummary(){
        String orderSummary = "Order Summary";
        return orderSummary;
    }
}
