package models;

public class Topping {

    private String name;
    private double price;

    // constructor
    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }
        // getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
