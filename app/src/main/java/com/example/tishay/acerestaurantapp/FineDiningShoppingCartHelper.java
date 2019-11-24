/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: FineDiningShoppingCartHelper.java
 * Stores information about all the products in the fine dining catalog in the user's shopping cart.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

package com.example.tishay.acerestaurantapp;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import android.content.res.Resources;

public class FineDiningShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> finediningCatalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    //add products to the fine dining catalog
    public static List<Product> getCatalog(Resources res){
        if(finediningCatalog == null) {
            finediningCatalog = new Vector<Product>();
            finediningCatalog.add(new Product("Shrimp and Wood-Grilled Chicken", res
                    .getDrawable(R.drawable.shrimpandwoodgrilledchicken),
                    "Shrimp prepared your way, plus a juicy, wood-fire grilled chicken breast for good measure. Served with our wild rice pilaf.", 15.00));
            finediningCatalog.add(new Product("Wild Caught Flounder", res
                    .getDrawable(R.drawable.wildcaughtflounder),
                    "This dish is perfect if you like your fish mild, flakey and prepared your way", 20.00));
            finediningCatalog.add(new Product("Maple Glazed Chicken", res
                    .getDrawable(R.drawable.mapleglazedchicken),
                    "This chicken dish is anything but ordinary. We brush a chicken breast with a maple-cherry glaze that’s a touch smoky and sweet, then grill it to juicy perfection and serve it over wild rice pilaf.",
                    10.00));
            finediningCatalog.add(new Product("Crab Linguini Alfredo", res
                    .getDrawable(R.drawable.crablinguinialfredo),
                    "Sweet, tender crabmeat in our creamy garlic Parmesan sauce served over linguini. Try it and don’t be surprised when you start craving it out of the blue.",
                    10.00));
            finediningCatalog.add(new Product("Center Cut Steak", res
                    .getDrawable(R.drawable.centercutsteak),
                    "We season it with peppercorns, throw it on our wood-fire grill, and serve it with mashed potatoes plus an extra side of your choice.", 10.00));
            finediningCatalog.add(new Product("Peppercorn Sirloin and Shrimp", res
                    .getDrawable(R.drawable.peppercornsirloinandshrimp),
                    "A juicy 7 oz. sirloin and a skewer of tender shrimp, both seasoned and wood-grilled to perfection.", 10.00));
        }

        return finediningCatalog;
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

    //remove the selected product
    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }


}