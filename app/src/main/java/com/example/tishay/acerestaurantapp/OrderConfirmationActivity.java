package com.example.tishay.acerestaurantapp;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class OrderConfirmationActivity extends AppCompatActivity
{

    //declares online experience button
    Button onlineExperienceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_confirmation);

        //sets the toolbar as the app bar for the activity
        android.support.v7.widget.Toolbar orderConfirmationToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.orderconfirmation_toolbar);
        setSupportActionBar(orderConfirmationToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_orderconfirmation_actionbar);

        setSupportActionBar(orderConfirmationToolbar);


        //when the home icon is clicked
        ImageView homeIconImageView = (ImageView) findViewById(R.id.homebutton_orderconfirmationscreen);
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //creates an intent that displays or opens the home screen
                Intent viewHomeScreenIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(viewHomeScreenIntent);

            }//end onClick()

        });


        //set the listener which specifies what happens every time the online experience button is clicked
        onlineExperienceButton = (Button) findViewById(R.id.onlineexperience);
        onlineExperienceButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //creates an intent that displays or opens the checkout screen
                        Toast.makeText(getBaseContext(),
                                "We apologize but this feature is temporarily unavailable.",
                                Toast.LENGTH_SHORT).show();

                    }//end onClick()


                }//end View.OnClickListener()


        );//end onlineExperienceButton.setOnClickListener


    }//end onCreate

}//end class OrderConfirmationActivity



