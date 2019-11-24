/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: Product.java
 * container for other objects that describe the product - title, image, and description.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

package com.example.tishay.acerestaurantapp;

import android.graphics.drawable.Drawable;

/**
 * Created by Tishay on 9/8/2016.
 */

import android.graphics.drawable.Drawable;

public class Product
{

    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public Product(String title, Drawable productImage, String description,
                   double price)
    {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
    }

}
