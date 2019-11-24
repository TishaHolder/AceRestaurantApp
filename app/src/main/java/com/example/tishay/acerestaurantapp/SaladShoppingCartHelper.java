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

public class SaladShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> saladCatalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    //add products to the salad catalog
    public static List<Product> getCatalog(Resources res){
        if(saladCatalog == null) {
            saladCatalog = new Vector<Product>();
            saladCatalog.add(new Product("New England Clam Chowder", res
                    .getDrawable(R.drawable.clamchowder),
                    "Creamy, comforting and perfect for a rainy day — or any day, really. Grab a Cheddar Bay Biscuit® and get in there.", 15.00));
            saladCatalog.add(new Product("Creamy Potato Bacon", res
                    .getDrawable(R.drawable.creamypotatobacon),
                    "Hearty, delicious and great for dipping Cheddar Bay Biscuits.", 20.00));
            saladCatalog.add(new Product("Classic Caesar Salad", res
                    .getDrawable(R.drawable.caesarsalad),
                    "The perfect mix of crisp romaine, crunchy croutons and shaved Parmesan cheese, served with our signature Caesar dressing.", 10.00));
            saladCatalog.add(new Product("Lobster Bisque", res
                    .getDrawable(R.drawable.lobsterbisque),
                    "Made with Maine and langostino lobster. The best of the ocean in one irresistibly creamy soup. ", 10.00));
            saladCatalog.add(new Product("Shrimp Salad", res
                    .getDrawable(R.drawable.shrimpsalad),
                    "Wood-grilled shrimp over crisp romaine, served with a cup of your *choice of soup.", 10.00));
            saladCatalog.add(new Product("Fried Fish Sandwich", res
                    .getDrawable(R.drawable.friedfishsandwich),
                    "Hand-breaded and fried until perfectly crunchy. Topped with your choice of Monterey Jack or cheddar cheese and served on a toasted brioche bun with french fries on the side.",
                    10.00));
        }

        return saladCatalog;
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