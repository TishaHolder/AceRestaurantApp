/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: FineDiningShoppingCartHelper.java
 * Stores information about all the products in the island flavor catalog in the user's shopping cart.
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

public class IslandFlavorShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> islandflavorCatalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    //adds products to the island flavor catalog
    public static List<Product> getCatalog(Resources res){
        if(islandflavorCatalog == null) {
            islandflavorCatalog = new Vector<Product>();
            islandflavorCatalog.add(new Product("Pork Chop with Apple Chutney", res
                    .getDrawable(R.drawable.porkchopwithapplechutney),
                    "Cajun-seasoned hand-cut pork chop, apple chutney, maple butter.", 12.00));
            islandflavorCatalog.add(new Product("Cedar Salmon", res
                    .getDrawable(R.drawable.cedarsalmon),
                    "Cedar-seasoned salmon, maple mustard glaze, sautéed spinach.", 15.00));
            islandflavorCatalog.add(new Product("Grains and Rice", res
                    .getDrawable(R.drawable.grainsandrice),
                    "Rice, garlic and onion is cooked in a hearty vegetable stock.", 17.00));
            islandflavorCatalog.add(new Product("Bourbon Street Steak", res
                    .getDrawable(R.drawable.bourbonstreetsteak),
                    "Two hand-cut 4 oz. USDA Choice top sirloins, sauteed onion & mushroom. Served sizzling with crispy red potatoes.", 17.00));
            islandflavorCatalog.add(new Product("Double Glazed Baby Back Ribs", res
                    .getDrawable(R.drawable.babybackribs),
                    "A full rack seasoned and slow-cooked to flavorful and tender perfection with your choice of sauce. Served with fries and cole slaw.", 17.00));
            islandflavorCatalog.add(new Product("BBQ Spiced Fries", res
                    .getDrawable(R.drawable.bbqspicefries),
                    "These unique alternatives to regular fries pack a powerful flavor punch in every crunch.", 17.00));
        }

        return islandflavorCatalog;
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