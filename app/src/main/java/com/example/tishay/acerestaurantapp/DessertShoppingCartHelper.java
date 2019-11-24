package com.example.tishay.acerestaurantapp;

/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: FineDiningShoppingCartHelper.java
 * Stores information about all the products in the fine dining catalog in the user's shopping cart.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/


import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class DessertShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> dessertCatalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    //creates the dessert catalog
    public static List<Product> getCatalog(Resources res){
        if(dessertCatalog == null) {
            dessertCatalog = new Vector<Product>();
            dessertCatalog.add(new Product("Brownie Overboard", res
                    .getDrawable(R.drawable.brownie),
                    "Dive into a warm, chocolatey brownie topped with a heaping scoop of vanilla ice cream, honey roasted pecans, a drizzle of caramel, fudge and whipped cream.",
                    15.00));
            dessertCatalog.add(new Product("Cracker Jack Banana Cheesecake", res
                    .getDrawable(R.drawable.bananacheesecake),
                    "Bananas foster sauce, Cracker Jack® popcorn & peanuts.",
                    20.00));
            dessertCatalog.add(new Product("Hot Fudge Sundae", res
                    .getDrawable(R.drawable.hotfudgesundae),
                    "Evenly layer hot fudge topping, Breyers® Extra Creamy Vanilla, walnuts and whipped cream.", 10.00));
            dessertCatalog.add(new Product("Apple Cheesecake", res
                    .getDrawable(R.drawable.applechimicheesecake),
                    "Creamy cheesecake and caramel apples wrapped in a tortilla shell and lightly fried.", 10.00));
            dessertCatalog.add(new Product("Churro S'Mores", res
                    .getDrawable(R.drawable.churrosmores),
                    "Churro twists, toasted marshmallow & chocolate dip. Hello, heaven.", 10.00));
            dessertCatalog.add(new Product("Chocolate Cake", res
                    .getDrawable(R.drawable.chocolatecake),
                    "Sink your fork into layers of warm, decadent chocolate cake and creamy fudge frosting, topped with vanilla ice cream and rich chocolate sauce. ",
                    10.00));
        }

        return dessertCatalog;
    }

    public static void setQuantity(Product product, int quantity) {

        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    //remove the current cart entry
    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    //create the cart list
    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {

            cartList.add(p);
        }

        return cartList;
    }


}