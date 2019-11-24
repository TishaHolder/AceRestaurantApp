/**
* IT633 : Mobile Application Development
* Final Project Part I Milesone One: MainActivity.java
* Student: Tisha Holder
* Instructor: Venkatesh Baglodi
* Due Date: September 11, 2016
**/

package com.example.tishay.acerestaurantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private View custom_home_actionbar;


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;


    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets the toolbar as the app bar for the activity
        Toolbar homeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(homeToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_home_actionbar);


        setSupportActionBar(homeToolbar);

        // Defined Array values to show in ListView
        String [] drawerOptions = {
                "Menu",
                "Online Ordering",
                "Calorie Counter",
                "Catering",
                "Beverage Mixer",
                "Reservations",
                "Get Directions",
                "About Us",
                "Contact Us"

        };//end array

        //create the navigation drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Create the ListView of navigation drawer's list of items
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        //Create an ArrayAdapter for the ListView of drawer options
        ArrayAdapter <String> drawerAdapter = new ArrayAdapter <String>(this,
                        android.R.layout.simple_list_item_1, drawerOptions);


        //Set the ListView to use the Adapter
        mDrawerList.setAdapter(drawerAdapter);


        // Set the list's click listener which specifies what happens every time an item in the main menu list is selected
        mDrawerList.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {

                        //creates an intent that displays or opens the screen with the restaurant's categorized menu
                        Intent menuScreenIntent = new Intent("com.example.tishay.acerestaurantapp.menu_screen_activity");

                        //get the index value of the list item that was selected and convert it to a string
                        String mainMenu = String.valueOf(parent.getItemAtPosition(position));

                        //if the user selects "menu" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Menu"))
                        {
                            startActivity(menuScreenIntent);

                        }//end if

                        //if the user selects "online ordering" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Online Ordering"))
                        {
                            startActivity(menuScreenIntent);

                        }//end if

                        //if the user selects "calorie counter" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Calorie Counter"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                    Toast.LENGTH_SHORT).show();

                        }//end if

                        //if the user selects "catering" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Catering"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                     Toast.LENGTH_SHORT).show();

                        }//end if

                        //if the user selects "beverage mixer" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Beverage Mixer"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                    Toast.LENGTH_SHORT).show();

                        }//end if

                        //if the user selects "reservations" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Reservations"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                     Toast.LENGTH_SHORT).show();

                        }//end if

                        //if the user selects "get directions" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Get Directions"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                    Toast.LENGTH_SHORT).show();

                        }//end if

                        //if the user selects "about us" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("About Us"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                    Toast.LENGTH_SHORT).show();

                        }//end if

                        //if the user selects "contact us" from the drawer menu, the restaurant's menu is displayed
                        if(mainMenu.equalsIgnoreCase("Contact Us"))
                        {
                            Toast.makeText(getBaseContext(),
                                    "We apologize but this feature is temporarily unavailable.",
                                    Toast.LENGTH_SHORT).show();

                        }//end if

                    }//end onItemClick()


                }//end new AdapterView

        );//end mainListView.setOnItemClickListener


        //when the menu icon on the home screen is clicked
        ImageView menuIconImageView = (ImageView) findViewById(R.id.menubutton_icon);
        menuIconImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                    //opens the navigation drawer
                    mDrawerLayout.openDrawer(GravityCompat.START);

            }//end onClick()

        });

        //creates the imageview shopping basket button and sets the listener that determines what happens when the button is clicked
        ImageView shoppingIconImageView = (ImageView) findViewById(R.id.shoppingbasketbutton_icon);
        shoppingIconImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //creates an intent that displays or opens the shopping cart
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);

            }

        });

        //Create the ListView of main menu options displayed on the home screen
        LinearLayout menuRow = (LinearLayout) findViewById(R.id.restaurantmenurow);
        LinearLayout onlineOrderingRow = (LinearLayout) findViewById(R.id.onlineorderingrow);
        LinearLayout cateringRow = (LinearLayout) findViewById(R.id.cateringrow);
        LinearLayout reservationsRow = (LinearLayout) findViewById(R.id.reservationsrow);
        LinearLayout signinRow = (LinearLayout) findViewById(R.id.signinrow);

        //set the listener which specifies what happens every time an item in the main menu list is selected
        menuRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //creates an intent that displays or opens the screen with the restaurant's categorized menu
                Intent menuScreenIntent = new Intent("com.example.tishay.acerestaurantapp.menu_screen_activity");
                startActivity(menuScreenIntent);

            }//end onClick()

        });//end setOnClickListener

        //set the listener which specifies what happens every time an item in the main menu list is selected
        onlineOrderingRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //creates an intent that displays or opens the screen with the restaurant's categorized menu
                Intent menuScreenIntent = new Intent("com.example.tishay.acerestaurantapp.menu_screen_activity");
                startActivity(menuScreenIntent);

            }//end onClick()

        });//end setOnClickListener

        //set the listener which specifies what happens every time an item in the main menu list is selected
        cateringRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),
                        "We apologize but this feature is temporarily unavailable.",
                        Toast.LENGTH_SHORT).show();

            }//end onClick()

        });//end setOnClickListener

        //set the listener which specifies what happens every time an item in the main menu list is selected
        reservationsRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),
                        "We apologize but this feature is temporarily unavailable.",
                        Toast.LENGTH_SHORT).show();

            }//end onClick()

        });//end setOnClickListener

        //set the listener which specifies what happens every time an item in the main menu list is selected
        signinRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),
                        "We apologize but this feature is temporarily unavailable.",
                        Toast.LENGTH_SHORT).show();

            }//end onClick()

        });//end setOnClickListener


    }//end onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_action, menu);
        return true;
    }


}//end class MainActivity
