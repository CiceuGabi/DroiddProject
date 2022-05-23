package com.droidd.model;

import java.util.HashMap;
import java.util.Map;

public class Invoice {

    private double subtotal;
    private double shippingFee;
    private double vat;
    private double total;
    private Map<Product, Integer> products = new HashMap<>();

    public Invoice(){};

    public Invoice(double subtotal, double shippingFee, double vat, double total, Map<Product, Integer> products) {
        this.subtotal = subtotal;
        this.shippingFee = shippingFee;
        this.vat = vat;
        this.total = total;
        this.products = products;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Subtotal: " + subtotal + "\nShipping: " + shippingFee + "\nVAT: " + vat + "\n\nTotal: " + total;
    }
}
