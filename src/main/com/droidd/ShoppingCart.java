package com.droidd;

import com.droidd.model.Invoice;
import com.droidd.model.Product;
import com.droidd.model.ShippingRates;

import java.util.*;

public class ShoppingCart {

   Map<Product, Integer> shoppingList = new HashMap<>();


    public void addItem(Product product, int quantity){
        shoppingList.put(product, shoppingList.containsKey(product) ? quantity + shoppingList.get(product) : quantity);
    }

    public Integer get(String item) {
        return shoppingList.get(item);
    }

    public void printItems() {
        for (Map.Entry<Product, Integer> entry : shoppingList.entrySet()) {
            System.out.println(entry.getKey().getName() + " X" + entry.getValue());
        }
    }

    public Invoice calculateInvoice(){

        double subtotal = 0;
        double shippingCosts = 0;
        double vat = 0;

        for (Map.Entry<Product, Integer> entry : shoppingList.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += product.getPrice() * quantity;

            shippingCosts += product.getWeight() * quantity * 10 * ShippingRates.valueOf(product.getShippedFrom().toUpperCase(Locale.ROOT)).getRate();

            vat += product.getPrice() * quantity * 0.19;
        }

        double total = subtotal + shippingCosts + vat;

        return new Invoice(subtotal, shippingCosts, vat, total, shoppingList);

    }
}
