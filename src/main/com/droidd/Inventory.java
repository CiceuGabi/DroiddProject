package com.droidd;

import com.droidd.model.Product;

import java.util.*;

public class Inventory {

    Map<Product, Integer> productList = new HashMap<>();

    public void addProduct(Product product, int quantity){
        productList.put(product, productList.containsKey(product) ? quantity + productList.get(product) : quantity);
    }
}
