package com.pluralsight;

import java.util.ArrayList;

public class Pizza {

    private String crustLevel;
    private String size;
    private String baseType;

    // arraylist
    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;


    // constructor
    public Pizza(String crustLevel, String size, String baseType) {
        this.crustLevel = crustLevel;
        this.size = size;
        this.baseType = baseType;
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

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    // price by size
    public double getPrice() {
        double price = 0.0;

        if (size.equalsIgnoreCase("small" + "s")) {
            price = 12;

        }
        else if (size.equalsIgnoreCase("medium" + "m")) {
            price = 14;
        }
        else if (size.equalsIgnoreCase("large" + "l")) {
            price = 16;
        }
        else if (size.equalsIgnoreCase("xlarge" + "xl")) {
            price = 18;
        }

        // extra charge for toppings
        price += meats.size() * 1.50;
        price += cheeses.size() * 1.00;

        return price;
    }
        // summary
    public String getSummary() {
        String summary = "";

        summary += "Size: " + size + "\n";
        summary += "Crust: " + crustLevel + "\n";
        summary += "Base: " + baseType + "\n";

        summary += "Meats: " + meats + "\n";
        summary += "Cheeses: " + cheeses + "\n";
        summary += "Toppings: " + toppings + "\n";
        summary += "Sauces: " + sauces + "\n";

        summary += "Price: $" + getPrice();
        return summary;

    }


}
