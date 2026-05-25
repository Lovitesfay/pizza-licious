package com.pluralsight;

public class Pizza {

    public String crustLevel;
    public String size;
    public String baseType;

    // constructor
    public Pizza(String crustLevel, String size, String baseType) {
        this.crustLevel = crustLevel;
        this.size = size;
        this.baseType = baseType;
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

    public String addMeat(){
        String meat = "Meat";
        return meat;
    }
    public String addCheese(){
        String cheese = "Cheese";
        return cheese;

    }
    public String addToppings(){
        String toppings = "Toppings";
        return toppings;

    }
    public String addSauce(){
        String sauce = "Sauce";
        return sauce;
    }

    public double getPrice(){
        double price = 0.0;
        return price;
    }

    public String getSummary(){
        String summary = "Summary";
        return summary;

    }




}
