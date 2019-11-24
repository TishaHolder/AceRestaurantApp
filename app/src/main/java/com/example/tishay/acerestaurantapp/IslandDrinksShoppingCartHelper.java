/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: Island Drinks ShoppingCartHelper.java
 * Stores information about all the products in the island drinks catalog in the user's shopping cart.
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

public class IslandDrinksShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> islanddrinksCatalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    //add products to the island drinks catalog
    public static List<Product> getCatalog(Resources res){
        if(islanddrinksCatalog == null) {
            islanddrinksCatalog = new Vector<Product>();
            islanddrinksCatalog.add(new Product("Shorty Shakes", res
                    .getDrawable(R.drawable.shortyshakes),
                    "salted caramel | chocolate nut brownie.", 20.00));
            islanddrinksCatalog.add(new Product("Frozen Lemonade", res
                    .getDrawable(R.drawable.frozenlemonade),
                    "Premium lemonade blended with ice and your choice of swirled mango or wildberry puree.",
                    5.00));
            islanddrinksCatalog.add(new Product("Brewed Ice Tea", res
                    .getDrawable(R.drawable.brewedicetea),
                    "Brewed fresh, daily.", 7.00));
            islanddrinksCatalog.add(new Product("Flavored Lemonade", res
                    .getDrawable(R.drawable.flavoredlemonade),
                    "Choose from pomegranate, raspberry, mango or kiwi flavors.", 12.00));
            islanddrinksCatalog.add(new Product("Limeade", res
                    .getDrawable(R.drawable.limeade),
                    "Made with fresh-squeezed lime juice and lemon-lime soda. ",
                    7.00));
            islanddrinksCatalog.add(new Product("Pepsi", res
                    .getDrawable(R.drawable.pepsi),
                    "Pepsi.", 7.00));
        }

        return islanddrinksCatalog;
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

    //removes current product
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