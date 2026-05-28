package models;

import java.util.ArrayList;

public class Pizza {

    private String crustLevel;
    private boolean stuffedCrust;
    private String size;
    private String sauce;

    // arraylist
    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;

    // constructor
    public Pizza(String crustLevel, boolean stuffedCrust,  String size, String sauce) {
        this.crustLevel = crustLevel;
        this.stuffedCrust = stuffedCrust;
        this.size = size;
        this.sauce = sauce;
        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();

    }

    // getters and setters

    public String getCrustLevel() {
        return crustLevel;
    }

    public void setCrustLevel(String crustLevel) {
        this.crustLevel = crustLevel;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList<String> getMeats() {
        return meats;
    }

    public ArrayList<String> getCheeses() {
        return cheeses;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public ArrayList<String> getSauces() {
        return sauces;
    }

    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addToppings(String topping) {
        toppings.add(topping);
    }

    public void showToppings() {
        toppings.forEach(System.out::println);
}
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    // price by size
    public double getPrice() {
        double price = 0.0;

        if (size.trim().equalsIgnoreCase("8 inch")) {
            price = 8;
        }
        else if (size.trim().equalsIgnoreCase("12 inch")) {
            price = 12;
        }
        else if (size.trim().equalsIgnoreCase("16 inch")) {
            price = 16;
        }

        if (stuffedCrust) {
            price += 2.00;
        }

        price += meats.size() * 1.50;
        price += cheeses.size() * 1.00;
        price += toppings.size() * 1.00;
        price += sauces.size() * 1.00;

        return price;
    }
        // summary
    public String getSummary() {
        String summary = "";

        summary += "Size: " + size + "\n";
        summary += "Crust: " + crustLevel + "\n";
        summary += "Stuffed Crust: " + stuffedCrust + "\n";
        summary += "Sauce: " + sauces + "\n";

        summary += "Meats: " + meats + "\n";
        summary += "Cheeses: " + cheeses + "\n";
        summary += "Toppings: " + toppings + "\n";

        summary += "Price: $" + getPrice();
        return summary;

    }

    @Override
    public String toString() {

        return "---------------------\n" +
                size + " Pizza\n" +
                "Crust: " + crustLevel + "\n" +
                "Stuffed Crust: " + stuffedCrust + "\n" +
                "Sauce: " + sauces + "\n" +
                "Meats: " + meats + "\n" +
                "Cheeses: " + cheeses + "\n" +
                "Toppings: " + toppings + "\n" +
                "Price: $" + getPrice() + "\n";


    }
}
