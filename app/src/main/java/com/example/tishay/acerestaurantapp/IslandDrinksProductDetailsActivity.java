/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: IslandDrinksProductDetailsActivity.java
 * Displays the product details for the products in the island drinks catalog.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

package com.example.tishay.acerestaurantapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import android.view.View.OnClickListener;

public class IslandDrinksProductDetailsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetails);

        //sets the toolbar as the app bar for the activity
        android.support.v7.widget.Toolbar menuScreenToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.menuscreen_toolbar);
        setSupportActionBar(menuScreenToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_home_actionbar);

        setSupportActionBar(menuScreenToolbar);//get a support action bar corresponding to the menu screen toolbar

        //creates the imageview back button and sets the listener that determines what happens when the button is clicked
        ImageView backButtonImageView = (ImageView) findViewById(R.id.backbutton_menuscreen);
        backButtonImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                //creates an intent that displays or opens the home screen
                Intent viewIslandDrinksMenuScreenIntent = new Intent(getBaseContext(), IslandDrinksCatalogActivity.class);
                startActivity(viewIslandDrinksMenuScreenIntent);

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

        List<Product> catalog = IslandDrinksShoppingCartHelper.getCatalog(getResources());

        int productIndex = getIntent().getExtras().getInt(
                IslandDrinksShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.title);
        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
        productDetailsTextView.setText(selectedProduct.description);

        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewProductPrice);
        productPriceTextView.setText (String.format("$%.2f", selectedProduct.price));


        // Update the current quantity in the cart
        TextView textViewCurrentQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart);
        textViewCurrentQuantity.setText(selectedProduct.title + " in Cart: "
                + IslandDrinksShoppingCartHelper.getProductQuantity(selectedProduct));

        // Save a reference to the quantity edit text
        final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);

        //creates add to cart button
        final Button removeFromCartButton = (Button) findViewById(R.id.removefromcart_button);

        //check to see if there are any of the item currently in the shopping cart
        if ((IslandDrinksShoppingCartHelper.getProductQuantity(selectedProduct))== 0)
        {
            removeFromCartButton.setEnabled(false);//disable remove button
            removeFromCartButton.setBackgroundColor(Color.parseColor("#808080"));//change the color of the button
        }


        //check to see if there are any of the item currently in the shopping cart
        if ((IslandDrinksShoppingCartHelper.getProductQuantity(selectedProduct))>= 1)
        {
            removeFromCartButton.setEnabled(true);//enable remove button
        }

        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Check to see that a valid quantity was entered
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(editTextQuantity.getText()
                            .toString());

                    if ((quantity < 0) || (quantity > 10)) {
                        Toast.makeText(getBaseContext(),
                                "Please enter a number between zero and ten",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),
                            "Please enter a number between zero and ten",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                // If we make it here, a valid quantity was entered
                IslandDrinksShoppingCartHelper.setQuantity(selectedProduct, quantity);


                //notifies the user that the item was successfully removed from their shopping cart if they entered zero
                if(quantity == 0 )
                {
                    Toast.makeText(getBaseContext(),
                            selectedProduct.title + " was successfully removed  from your shopping cart.",
                            Toast.LENGTH_SHORT).show();

                    //remove the product from the shopping cart when the add to cart button is pressed and the user entered zero
                    IslandDrinksShoppingCartHelper.removeProduct(selectedProduct);

                }
                else

                    //notifies the user that the item was successfully added to their shopping cart
                    Toast.makeText(getBaseContext(),
                            selectedProduct.title + " was successfully added to your shopping cart.",
                            Toast.LENGTH_SHORT).show();

                if ((IslandDrinksShoppingCartHelper.getProductQuantity(selectedProduct) >= 1))
                {
                    removeFromCartButton.setEnabled(true);//enable remove button
                }

                //creates an intent that displays or opens the shopping cart
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);


                // Close the activity
                finish();
            }
        });

        //sets the listener to the removeFromCart button to determine what happens when the button is clicked
        removeFromCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                // If we make it here, a valid quantity was entered
                IslandDrinksShoppingCartHelper.setQuantity(selectedProduct, 0);

                //notifies the user that the item was successfully removed from their shopping cart if they entered zero

                Toast.makeText(getBaseContext(),
                        selectedProduct.title + " was successfully removed  from your shopping cart.",
                        Toast.LENGTH_SHORT).show();

                //remove the product from the shopping cart when the remove from cart button is pressed
                IslandDrinksShoppingCartHelper.removeProduct(selectedProduct);



                //check to see if there are any of the item currently in the shopping cart
                if ((IslandDrinksShoppingCartHelper.getProductQuantity(selectedProduct))== 0)
                {
                    removeFromCartButton.setEnabled(false);//disable remove button
                    removeFromCartButton.setBackgroundColor(Color.parseColor("#808080"));//change the color of the button
                }


                //creates an intent that displays or opens the shopping cart
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);


                // Close the activity
                finish();

            }
        });//end removeFromCart setOnClickListener

    }

}