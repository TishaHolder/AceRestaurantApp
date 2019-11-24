package com.example.tishay.acerestaurantapp;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import android.content.res.Resources;
/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: SeaFoodShoppingCartHelper.java
 * Stores information about all the products in the sea food catalog in the user's shopping cart.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

public class SeaFoodShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> seafoodCatalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    //add products to the sea food catalog
    public static List<Product> getCatalog(Resources res){
        if(seafoodCatalog == null) {
            seafoodCatalog = new Vector<Product>();
            seafoodCatalog.add(new Product("Seaside Shrimp Trio", res
                    .getDrawable(R.drawable.seasideshrimptrio),
                    "A generous sampling of guest favorites: Walt’s Favorite Shrimp, hand-crafted garlic shrimp scampi and our famous shrimp linguini Alfredo",
                    15.00));
            seafoodCatalog.add(new Product("Jumbo Coconut Shrimp", res
                    .getDrawable(R.drawable.jumbococonutshrimp),
                    "Hand-dipped jumbo shrimp tossed in flaky coconut and fried until perfectly crisp. Dunk them in our signature piña colada sauce and hello, paradise.",
                    20.00));
            seafoodCatalog.add(new Product("Garlic-Grilled Shrimp", res
                    .getDrawable(R.drawable.garlicgrilledshrimp),
                    "A skewer of shrimp brushed with a buttery garlic glaze for extra flavor.", 10.00));
            seafoodCatalog.add(new Product("Shrimp Linguini Alfredo", res
                    .getDrawable(R.drawable.shrimplinguinialfredo),
                    "Tender shrimp in our famous creamy garlic Parmesan sauce, served over linguini.", 10.00));
            seafoodCatalog.add(new Product("Snow Crab Legs", res
                    .getDrawable(R.drawable.snowcrablegs),
                    "Steamed tender chunks of snow-white wild caught snow crab legs.", 10.00));
            seafoodCatalog.add(new Product("Fish and Chips", res
                    .getDrawable(R.drawable.fishandchips),
                    "Tender, flakey fish fried to perfection and served with our signature tartar sauce and malt vinegar.", 10.00));
        }

        return seafoodCatalog;
    }

    public static void setQuantity(Product product, int quantity)
    {

        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0)
        {
            if(curEntry != null)
                removeProduct(product);
            return;
        }//end if

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }//end if

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product)
    {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;

    }//end getProductQuantity()

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList()
    {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet())
        {
            cartList.add(p);

        }//end for

        return cartList;

    }//end getCartList()

}//end class SeaFoodShoppingCartHelper