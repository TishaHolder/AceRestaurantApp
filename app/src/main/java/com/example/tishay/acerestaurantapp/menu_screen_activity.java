/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: menu_screen_activity.java
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

package com.example.tishay.acerestaurantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.view.View;
import android.widget.ImageButton;
import android.widget.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Toolbar;


public class menu_screen_activity extends AppCompatActivity
{
    //image buttons that make up the categorized menu
    Button fineDiningButton;
    Button seaFoodButton;
    Button islandFlavorButton;
    Button islandDrinksButton;
    Button dessertButton;
    Button saladButton;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen_activity);

        //sets the toolbar as the app bar for the activity
        android.support.v7.widget.Toolbar menuScreenToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.menuscreen_toolbar);
        setSupportActionBar(menuScreenToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_home_actionbar);

        setSupportActionBar(menuScreenToolbar);

        //creates the imageview back button and sets the listener that determines what happens when the button is clicked
        ImageView backButtonImageView = (ImageView) findViewById(R.id.backbutton_menuscreen);
        backButtonImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

               //creates an intent that displays or opens the home screen
                Intent viewHomeScreenIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(viewHomeScreenIntent);

            }//end onClick()

        });

        //creates the imageview shopping button and sets the listener that determines what happens when the button is clicked
        ImageView shoppingIconImageView = (ImageView) findViewById(R.id.shoppingbasketbutton_icon);
        shoppingIconImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //creates an intent that displays or opens the shopping cart
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);

            }

        });


        OnClickButtonListener();//calls OnClickButtonListener() that dictates what happens when each menu button is clicked

    }//end onCreate

    // Access the image buttons defined in menu_screen_activity layout and listen for them here
    public void OnClickButtonListener()
    {
        //when the fine dining button is clicked, the fine dining catalog is opened
        fineDiningButton = (Button) findViewById(R.id.imageButtonFineDining);
        fineDiningButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the fine dining catalog
                        Intent fineDiningScreenIntent = new Intent("com.example.tishay.acerestaurantapp.FineDiningCatalogActivity");

                        startActivity(fineDiningScreenIntent);//opens the fine dining catalog

                    }//end onClick()

                }//end View.OnClickListener()

        );//end fineDiningButton.setOnClickListener

        //when the sea food button is clicked, the sea food catalog is opened
        seaFoodButton = (Button) findViewById(R.id.imageButtonSeafood);
        seaFoodButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the sea food catalog
                        Intent seaFoodScreenIntent = new Intent("com.example.tishay.acerestaurantapp.SeaFoodCatalogActivity");

                        startActivity(seaFoodScreenIntent);//creates an intent that displays or opens the sea food catalog

                    }//end onClick()


                }//end View.OnClickListener()


        );//end seaFoodButton.setOnClickListener

        //when the island flavor button is clicked, the island flavor catalog is opened
        islandFlavorButton = (Button) findViewById(R.id.imageButtonIslandFlavor);
        islandFlavorButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the island flavor catalog
                        Intent islandFlavorScreenIntent = new Intent("com.example.tishay.acerestaurantapp.IslandFlavorCatalogActivity");

                        startActivity(islandFlavorScreenIntent);//creates an intent that displays or opens the island flavor catalog

                    }//end onClick()

                }//end View.OnClickListener()


        );//end islandFlavorButton.setOnClickListener()

        //when the island drinks button is clicked, the island drinks catalog is opened
        islandDrinksButton = (Button) findViewById(R.id.imageButtonIslandDrinks);
        islandDrinksButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the island drinks catalog
                        Intent islandDrinksScreenIntent = new Intent("com.example.tishay.acerestaurantapp.IslandDrinksCatalogActivity");

                        startActivity(islandDrinksScreenIntent);//creates an intent that displays or opens the island drinks catalog

                    }//end onClick()

                }//end View.OnClickListener()

        );//end islandDrinksButton.setOnClickListener

        //when the dessert button is clicked, the dessert catalog is opened
        dessertButton = (Button) findViewById(R.id.imageButtonDessert);
        dessertButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the island drinks catalog
                        Intent dessertScreenIntent = new Intent("com.example.tishay.acerestaurantapp.DessertCatalogActivity");

                        startActivity(dessertScreenIntent);//creates an intent that displays or opens the island drinks catalog

                    }//end onClick()

                }//end View.OnClickListener()

        );//end islandDrinksButton.setOnClickListener()

        //when the salad button is clicked, the salad catalog is opened
        saladButton = (Button) findViewById(R.id.imageButtonSalad);
        saladButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the island drinks catalog
                        Intent saladScreenIntent = new Intent("com.example.tishay.acerestaurantapp.SaladCatalogActivity");

                        startActivity(saladScreenIntent);//creates an intent that displays or opens the island drinks catalog

                    }//end onClick()

                }//end View.OnClickListener()

        );//end islandDrinksButton.setOnClickListener()

    }//end OnClickButtonListener

}//end menu_screen_activity class
