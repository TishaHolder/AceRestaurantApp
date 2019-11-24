/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: SubmitOrderActivity.java
 * Displays the submit order screen
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

package com.example.tishay.acerestaurantapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class SubmitOrderActivity extends AppCompatActivity {

    //back to order and place order buttons on the submit order screen
    Button backToOrderButton;
    Button placeOrderButton;

    EditText name;
    EditText email;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_order);


        //sets the toolbar as the app bar for the activity
        android.support.v7.widget.Toolbar checkOutScreenToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.checkoutscreen_toolbar);
        setSupportActionBar(checkOutScreenToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_home_actionbar);

        setSupportActionBar(checkOutScreenToolbar);

        //when the back is clicked, the shopping cart screen is opened
        ImageView backButtonImageView = (ImageView) findViewById(R.id.backbutton_checkoutscreen);
        backButtonImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                //creates an intent that displays or opens the shopping cart
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);

            }//end onClick()

        });


        //when the home button is clicked, the home screen is opened
        ImageView homeButtonImageView = (ImageView) findViewById(R.id.homebutton_checkoutscreen);
        homeButtonImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                ///creates an intent that displays or opens the home screen
                Intent viewHomeScreenIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(viewHomeScreenIntent);

            }//end onClick()

        });

        name = (EditText) findViewById(R.id.name_edittext);
        email = (EditText) findViewById(R.id.email_edittext);
        phoneNumber = (EditText) findViewById(R.id.phonenumber_edittext);

        //when the back to order button is clicked, the shopping cart screen is opened
        backToOrderButton = (Button) findViewById(R.id.backtoorder_button);
        backToOrderButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                        startActivity(viewShoppingCartIntent);

                    }//end onClick()

                }//end View.OnClickListener()

        );//end addMoreItemsButton.setOnClickListener

        //when the place order button is clicked, the order confirmation screen is opened
        placeOrderButton = (Button) findViewById(R.id.placeorder_button);
        placeOrderButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //checks if the user filled out their name, email, and phone number on the order confirmation screen
                        if(name.length() == 0 || email.length() == 0 || phoneNumber.length() == 0)
                        {
                            Toast.makeText(getBaseContext(),
                                    "Please enter a contact name, email address, and phone number",
                                    Toast.LENGTH_SHORT).show();

                        }//end if
                        else
                        {

                            Intent orderConfirmationScreenIntent = new Intent(getBaseContext(), OrderConfirmationActivity.class);
                            startActivity(orderConfirmationScreenIntent);

                        }//end else

                    }//end onClick()


                }//end View.OnClickListener()


        );//end checkoutButton.setOnClickListener


    }//end onCreate()

}//end class SubmitOrderActivity
