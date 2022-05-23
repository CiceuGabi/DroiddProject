package com.droidd;

import com.droidd.model.Invoice;
import com.droidd.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

class ShoppingCartTest {

    @org.junit.jupiter.api.Test
    void verifyProducts() {

        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem(Product.MOUSE, 1);
        shoppingCart.addItem(Product.MOUSE, 3);
        shoppingCart.addItem(Product.MOUSE, 4);
        shoppingCart.addItem(Product.MOUSE, 6);
        shoppingCart.addItem(Product.MOUSE, 4);
        shoppingCart.addItem(Product.HEADPHONES, 2);
        shoppingCart.addItem(Product.WEBCAM, 6);

        Invoice i = shoppingCart.calculateInvoice();
        i.getProducts().get(Product.MOUSE);

        Assertions.assertEquals(i.getProducts().get(Product.MOUSE), 18);
        Assertions.assertEquals(i.getProducts().get(Product.HEADPHONES), 2);
        Assertions.assertEquals(i.getProducts().get(Product.WEBCAM), 6);




    }

    @org.junit.jupiter.api.Test
    void verifyFees() {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(Product.HEADPHONES, 1);
        shoppingCart.addItem(Product.MOUSE, 1);
        shoppingCart.addItem(Product.WEBCAM, 1);

        Invoice i = shoppingCart.calculateInvoice();

        Assert.assertEquals("Subtotal doesn't match", i.getSubtotal(), 155.97, 0.01);
        Assert.assertEquals("Shipping fee doesn't match", i.getShippingFee(), 22.0, 0.01);
        Assert.assertEquals("VAT doesn't match", i.getVat(), 29.63, 0.01);
        Assert.assertEquals("Total doesn't match", i.getTotal(), 207.60, 0.01);


    }
}