package com.droidd;

import com.droidd.model.Product;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();
        Inventory inventory = populateInventory();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Welcome to our shop");
        System.out.print("Press enter to begin:");
        String userInput = scanner.nextLine();

        boolean checkoutComplete = false;
        while (!userInput.equalsIgnoreCase("x") && !checkoutComplete) {
            displayMenu();


            String input = scanner.nextLine();
            int number;
            try {
                number = Integer.parseInt(input);
            }catch (NumberFormatException nfe){
                System.out.println("Option should be numeric!");
                continue;
            }

            switch (number) {
                case 1:
                    displayCatalog();
                    break;
                case 2:
                    System.out.print("Please insert the product name:");
                    String item = scanner1.nextLine();
                    if (Arrays.stream(Product.values()).anyMatch(product -> product.getName().equalsIgnoreCase(item))) {

                        shoppingCart.addItem(Product.valueOf(item.toUpperCase(Locale.ROOT)), 1);

                        System.out.println("\nYour shopping cart: ");
                        shoppingCart.printItems();
                        break;
                    } else {
                        System.out.println("Invalid item!");
                        break;
                    }


                case 3:
                    System.out.println("\nYour shopping cart: ");
                    shoppingCart.printItems();
                    break;

                case 4:
                    System.out.println(shoppingCart.calculateInvoice().toString());
                    checkoutComplete = true;
                    break;

                default:
                    System.out.println("Please choose a valid option");
                    break;
            }
        }

    }

    private static Inventory populateInventory() {
        Inventory inventory = new Inventory();
        inventory.addProduct(Product.MOUSE, 5);
        inventory.addProduct(Product.DESK_LAMP, 2);
        inventory.addProduct(Product.MONITOR, 4);
        inventory.addProduct(Product.WEBCAM, 3);
        inventory.addProduct(Product.HEADPHONES, 2);
        inventory.addProduct(Product.KEYBOARD, 7);

        return inventory;
    }

    private static void displayCatalog() {
        Arrays.stream(Product.values()).forEach(product -> System.out.println(product.getName() + " - $" + product.getPrice()));
    }

    private static void displayMenu() {
        System.out.println("\nPlease choose one of the following options: ");

        System.out.println("1 - Display products");
        System.out.println("2 - Add products to shopping cart");
        System.out.println("3 - Display shopping cart");
        System.out.println("4 - Go to checkout");
        System.out.println("x - Exit");

        System.out.print("Your answer: ");
    }
}
