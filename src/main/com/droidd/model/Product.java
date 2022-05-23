package com.droidd.model;

public enum Product {
    MOUSE("Mouse", 10.99, 0.2, "RO"),
    KEYBOARD("Keyboard", 40.99, 0.7, "UK"),
    MONITOR("Monitor", 164.99, 1.9, "US"),
    WEBCAM("Webcam", 84.99, 0.2, "RO"),
    HEADPHONES("Headphones", 59.99, 0.6, "US"),
    DESK_LAMP("Desk Lamp", 89.99, 1.3, "UK");


    private String name;
    private double price;
    private double weight;
    private String shippedFrom;


    Product(String name, double price, double weight, String shippedFrom) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.shippedFrom = shippedFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getShippedFrom() {
        return shippedFrom;
    }

    public void setShippedFrom(String shippedFrom) {
        this.shippedFrom = shippedFrom;
    }
}
