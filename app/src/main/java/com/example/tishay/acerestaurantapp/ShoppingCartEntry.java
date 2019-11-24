/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: ShoppingCartEntry.java
 * container for other objects that describe the products in the shopping cart - title, image, and description.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/


package com.example.tishay.acerestaurantapp;


public class ShoppingCartEntry
{

    private Product mProduct;
    private int mQuantity;

    public ShoppingCartEntry(Product product, int quantity)
    {
        mProduct = product;
        mQuantity = quantity;

    }//end ShoppingCartEntry()

    public Product getProduct() {
        return mProduct;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity += quantity;
    }

}//end class ShoppingCartEntry
