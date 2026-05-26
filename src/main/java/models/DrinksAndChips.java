package models;

import java.util.ArrayList;

public class DrinksAndChips {

    private String name;
    private String size;
    private double price;


    // constructor
    public DrinksAndChips(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // summary
    public String getSummary() {
        return size + " " + name + " - $" + price;
    }
}
