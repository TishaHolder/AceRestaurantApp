/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: FineDiningCatalogActivity.java
 * Displays all the available products from the fine dining catalog.
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

public class SaladCatalogActivity extends AppCompatActivity
{
    //stores fine dining restaurant items
    private List<Product> mProductList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salad_catalog);

        //sets the toolbar as the app bar for the activity
        android.support.v7.widget.Toolbar menuScreenToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.menuscreen_toolbar);
        setSupportActionBar(menuScreenToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_home_actionbar);


        setSupportActionBar(menuScreenToolbar);

        //creates image view with the back button and assigns listener that determines what happens when the button is clicked
        ImageView backButtonImageView = (ImageView) findViewById(R.id.backbutton_menuscreen);
        backButtonImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                //creates an intent that displays or opens the home screen
                Intent viewMenuScreenIntent = new Intent(getBaseContext(), menu_screen_activity.class);
                startActivity(viewMenuScreenIntent);

            }//end onClick()

        });

        //creates image view with the shopping cart button and assigns listener that determines what happens when the button is clicked
        ImageView shoppingIconImageView = (ImageView) findViewById(R.id.shoppingbasketbutton_icon);
        shoppingIconImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //creates an intent that displays or opens the shopping cart
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);

            }

        });

        // Obtain a reference to the salad product catalog
        mProductList = SaladShoppingCartHelper.getCatalog(getResources());

        // Create the saladcatalog list
        ListView listViewCatalog = (ListView) findViewById(R.id.saladcatalog_listview);
        listViewCatalog.setAdapter(new SaladProductAdapter(mProductList, getLayoutInflater(), false, false));

        //each time a product in the salad catalog is clicked, opens that product details page
        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),SaladProductDetailsActivity.class);
                productDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);

            }
        });//end setOnClickListener


    }//end onCreate()

}//end class FineDiningCatalogActivity