/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: ShoppingCartActivity.java
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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;

public class ShoppingCartActivity extends AppCompatActivity
{
    //add more items and checkout buttons on the shopping cart screen
    Button addMoreItemsButton;
    Button checkoutButton;

    double fineDiningSubTotal = 0;//stores the dollar amount total of all fine dining items added to the cart
    double seaFoodSubTotal = 0;//stores the dollar amount total of all sea food items added to the cart
    double islandFlavorSubTotal = 0;//stores the dollar amount total of all island flavor items added to the cart
    double islandDrinksSubTotal = 0;//stores the dollar amount total of all island drink items added to the cart
    double dessertSubTotal = 0;//stores the dollar amount total of all dessert items added to the cart
    double saladSubTotal = 0;//stores the dollar amount total of all salad items added to the cart
    double subtotal = 0;//stores the subtotal of all items added to the cart


    //lists to store products selected from each restaurant menu category
    private List<Product> fineDiningCartList;
    private List<Product> seaFoodCartList;
    private List<Product> islandFlavorCartList;
    private List<Product> islandDrinksCartList;
    private List<Product> dessertCartList;
    private List<Product> saladCartList;

    //adapters for each list
    private FineDiningProductAdapter fineDiningProductAdapter;
    private SeaFoodProductAdapter seaFoodProductAdapter;
    private IslandFlavorProductAdapter islandFlavorProductAdapter;
    private IslandDrinksProductAdapter islandDrinksProductAdapter;
    private DessertProductAdapter dessertProductAdapter;
    private SaladProductAdapter saladProductAdapter;

    //merge adapter used to attach the different adapters to one adapter to display the list in the shopping cart
    MergeAdapter mergeAdapter;

    TextView productPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);

        //sets the toolbar as the app bar for the activity
        android.support.v7.widget.Toolbar shoppingCartToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.shoppingcart_toolbar);
        setSupportActionBar(shoppingCartToolbar);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_home_actionbar);

        setSupportActionBar(shoppingCartToolbar);

        //creates the imageview home button and sets the listener that determines what happens when the button is clicked
        ImageView homeButtonImageView = (ImageView) findViewById(R.id.homebutton_shoppingcartscreen);
        homeButtonImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                ///creates an intent that displays or opens the home screen
                Intent viewHomeScreenIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(viewHomeScreenIntent);

            }//end onClick()

        });


        //stores the list of products selected from each restaurant catalog in a list
        fineDiningCartList = FineDiningShoppingCartHelper.getCartList();
        seaFoodCartList = SeaFoodShoppingCartHelper.getCartList();
        islandFlavorCartList = IslandFlavorShoppingCartHelper.getCartList();
        islandDrinksCartList = IslandDrinksShoppingCartHelper.getCartList();
        dessertCartList = DessertShoppingCartHelper.getCartList();
        saladCartList = SaladShoppingCartHelper.getCartList();

        //creates the MergeAdapter
        mergeAdapter = new MergeAdapter();

        // Create the list to be displayed on the shopping cart screen
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);


        //creates the list adapter for the fine dining category
        fineDiningProductAdapter = new FineDiningProductAdapter(fineDiningCartList, getLayoutInflater(), true, true);

        //adds the fineDiningProductAdapter to the merge adapter
        mergeAdapter.addAdapter(fineDiningProductAdapter);

        listViewCatalog.setAdapter(mergeAdapter);//assigns the adapter to the list view


        //creates the list adapter for the sea food catalog and assigns it to the list view
        seaFoodProductAdapter = new SeaFoodProductAdapter(seaFoodCartList, getLayoutInflater(), true, true);


        mergeAdapter.addAdapter(seaFoodProductAdapter);

        listViewCatalog.setAdapter(mergeAdapter);//assigns the adapter to the list view



        //creates the list adapter for the island flavor catalog and assigns it to the list view
        islandFlavorProductAdapter = new IslandFlavorProductAdapter(islandFlavorCartList, getLayoutInflater(), true, true);

        mergeAdapter.addAdapter(islandFlavorProductAdapter);

        listViewCatalog.setAdapter(mergeAdapter);//assigns the adapter to the list view



        //creates the list adapter for the island drinks catalog and assigns it to the list view
        islandDrinksProductAdapter = new IslandDrinksProductAdapter(islandDrinksCartList, getLayoutInflater(), true, true);

        mergeAdapter.addAdapter(islandDrinksProductAdapter);

        listViewCatalog.setAdapter(mergeAdapter);//assigns the adapter to the list view



        //creates the list adapter for the dessert category
        dessertProductAdapter = new DessertProductAdapter(dessertCartList, getLayoutInflater(), true, true);

        //adds the dessertProductAdapter to the merge adapter
        mergeAdapter.addAdapter(dessertProductAdapter);

        listViewCatalog.setAdapter(mergeAdapter);//assigns the adapter to the list view


        //creates the list adapter for the salad category
        saladProductAdapter = new SaladProductAdapter(saladCartList, getLayoutInflater(), true, true);

        //adds the saladProductAdapter to the merge adapter
        mergeAdapter.addAdapter(saladProductAdapter);

        listViewCatalog.setAdapter(mergeAdapter);//assigns the adapter to the list view


                //opens the product details page of the item clicked in the shopping cart
                listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {

                        //stores the product in the shopping cart list view specified by position
                        final Product item = (Product)mergeAdapter.getItem(position);

                        //if structure that checks each position in the fine dining catalog for the item in the list view
                        //********** fine dining products
                        if(item.title.equalsIgnoreCase("Shrimp and Wood-Grilled Chicken"))
                        {
                            Intent fineDiningProductDetailsIntent = new Intent(getBaseContext(), FineDiningProductDetailsActivity.class);
                            fineDiningProductDetailsIntent.putExtra(FineDiningShoppingCartHelper.PRODUCT_INDEX, 0);
                            startActivity(fineDiningProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Wild Caught Flounder"))
                        {
                            Intent fineDiningProductDetailsIntent = new Intent(getBaseContext(), FineDiningProductDetailsActivity.class);
                            fineDiningProductDetailsIntent.putExtra(FineDiningShoppingCartHelper.PRODUCT_INDEX, 1);
                            startActivity(fineDiningProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Maple Glazed Chicken"))
                        {
                            Intent fineDiningProductDetailsIntent = new Intent(getBaseContext(), FineDiningProductDetailsActivity.class);
                            fineDiningProductDetailsIntent.putExtra(FineDiningShoppingCartHelper.PRODUCT_INDEX, 2);
                            startActivity(fineDiningProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Crab Linguini Alfredo"))
                        {
                            Intent fineDiningProductDetailsIntent = new Intent(getBaseContext(), FineDiningProductDetailsActivity.class);
                            fineDiningProductDetailsIntent.putExtra(FineDiningShoppingCartHelper.PRODUCT_INDEX, 3);
                            startActivity(fineDiningProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Center Cut Steak"))
                        {
                            Intent fineDiningProductDetailsIntent = new Intent(getBaseContext(), FineDiningProductDetailsActivity.class);
                            fineDiningProductDetailsIntent.putExtra(FineDiningShoppingCartHelper.PRODUCT_INDEX, 4);
                            startActivity(fineDiningProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Peppercorn Sirloin and Shrimp"))
                        {
                            Intent fineDiningProductDetailsIntent = new Intent(getBaseContext(), FineDiningProductDetailsActivity.class);
                            fineDiningProductDetailsIntent.putExtra(FineDiningShoppingCartHelper.PRODUCT_INDEX, 5);
                            startActivity(fineDiningProductDetailsIntent);

                        }

                        //if structure that checks each position in the sea food catalog for the item in the list view
                        //********** sea food products
                        if(item.title.equalsIgnoreCase("Seaside Shrimp Trio"))
                        {
                            Intent seaFoodProductDetailsIntent = new Intent(getBaseContext(), SeaFoodProductDetailsActivity.class);
                            seaFoodProductDetailsIntent.putExtra(SeaFoodShoppingCartHelper.PRODUCT_INDEX, 0);
                            startActivity(seaFoodProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Jumbo Coconut Shrimp"))
                        {
                            Intent seaFoodProductDetailsIntent = new Intent(getBaseContext(), SeaFoodProductDetailsActivity.class);
                            seaFoodProductDetailsIntent.putExtra(SeaFoodShoppingCartHelper.PRODUCT_INDEX, 1);
                            startActivity(seaFoodProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Garlic-Grilled Shrimp"))
                        {
                            Intent seaFoodProductDetailsIntent = new Intent(getBaseContext(), SeaFoodProductDetailsActivity.class);
                            seaFoodProductDetailsIntent.putExtra(SeaFoodShoppingCartHelper.PRODUCT_INDEX, 2);
                            startActivity(seaFoodProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Shrimp Linguini Alfredo"))
                        {
                            Intent seaFoodProductDetailsIntent = new Intent(getBaseContext(), SeaFoodProductDetailsActivity.class);
                            seaFoodProductDetailsIntent.putExtra(SeaFoodShoppingCartHelper.PRODUCT_INDEX, 3);
                            startActivity(seaFoodProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Snow Crab Legs"))
                        {
                            Intent seaFoodProductDetailsIntent = new Intent(getBaseContext(), SeaFoodProductDetailsActivity.class);
                            seaFoodProductDetailsIntent.putExtra(SeaFoodShoppingCartHelper.PRODUCT_INDEX, 4);
                            startActivity(seaFoodProductDetailsIntent);

                        }

                        if(item.title.equalsIgnoreCase("Fish and Chips"))
                        {
                            Intent seaFoodProductDetailsIntent = new Intent(getBaseContext(), SeaFoodProductDetailsActivity.class);
                            seaFoodProductDetailsIntent.putExtra(SeaFoodShoppingCartHelper.PRODUCT_INDEX, 5);
                            startActivity(seaFoodProductDetailsIntent);

                        }


                        //if structure that checks each position in the island flavor catalog for the item in the list view
                        //********** island flavor products
                        if(item.title.equalsIgnoreCase("Pork Chop with Apple Chutney"))
                        {
                            Intent islandFlavorProductDetailsIntent = new Intent(getBaseContext(), IslandFlavorProductDetailsActivity.class);
                            islandFlavorProductDetailsIntent.putExtra(IslandFlavorShoppingCartHelper.PRODUCT_INDEX, 0);
                            startActivity(islandFlavorProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Cedar Salmon"))
                        {
                            Intent islandFlavorProductDetailsIntent = new Intent(getBaseContext(), IslandFlavorProductDetailsActivity.class);
                            islandFlavorProductDetailsIntent.putExtra(IslandFlavorShoppingCartHelper.PRODUCT_INDEX, 1);
                            startActivity(islandFlavorProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Grains and Rice"))
                        {
                            Intent islandFlavorProductDetailsIntent = new Intent(getBaseContext(), IslandFlavorProductDetailsActivity.class);
                            islandFlavorProductDetailsIntent.putExtra(IslandFlavorShoppingCartHelper.PRODUCT_INDEX, 2);
                            startActivity(islandFlavorProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Bourbon Street Steak"))
                        {
                            Intent islandFlavorProductDetailsIntent = new Intent(getBaseContext(), IslandFlavorProductDetailsActivity.class);
                            islandFlavorProductDetailsIntent.putExtra(IslandFlavorShoppingCartHelper.PRODUCT_INDEX, 3);
                            startActivity(islandFlavorProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Double Glazed Baby Back Ribs"))
                        {
                            Intent islandFlavorProductDetailsIntent = new Intent(getBaseContext(), IslandFlavorProductDetailsActivity.class);
                            islandFlavorProductDetailsIntent.putExtra(IslandFlavorShoppingCartHelper.PRODUCT_INDEX, 4);
                            startActivity(islandFlavorProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("BBQ Spiced Fries"))
                        {
                            Intent islandFlavorProductDetailsIntent = new Intent(getBaseContext(), IslandFlavorProductDetailsActivity.class);
                            islandFlavorProductDetailsIntent.putExtra(IslandFlavorShoppingCartHelper.PRODUCT_INDEX, 5);
                            startActivity(islandFlavorProductDetailsIntent);
                        }

                        //if structure that checks each position in the island drinks catalog for the item in the list view
                        //********** island drinks products
                        if(item.title.equalsIgnoreCase("Shorty Shakes"))
                        {
                            Intent islandDrinksProductDetailsIntent = new Intent(getBaseContext(), IslandDrinksProductDetailsActivity.class);
                            islandDrinksProductDetailsIntent.putExtra(IslandDrinksShoppingCartHelper.PRODUCT_INDEX, 0);
                            startActivity(islandDrinksProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Frozen Lemonade"))
                        {
                            Intent islandDrinksProductDetailsIntent = new Intent(getBaseContext(), IslandDrinksProductDetailsActivity.class);
                            islandDrinksProductDetailsIntent.putExtra(IslandDrinksShoppingCartHelper.PRODUCT_INDEX, 1);
                            startActivity(islandDrinksProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Brewed Ice Tea"))
                        {
                            Intent islandDrinksProductDetailsIntent = new Intent(getBaseContext(), IslandDrinksProductDetailsActivity.class);
                            islandDrinksProductDetailsIntent.putExtra(IslandDrinksShoppingCartHelper.PRODUCT_INDEX, 2);
                            startActivity(islandDrinksProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Flavored Lemonade"))
                        {
                            Intent islandDrinksProductDetailsIntent = new Intent(getBaseContext(), IslandDrinksProductDetailsActivity.class);
                            islandDrinksProductDetailsIntent.putExtra(IslandDrinksShoppingCartHelper.PRODUCT_INDEX, 3);
                            startActivity(islandDrinksProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Limeade"))
                        {
                            Intent islandDrinksProductDetailsIntent = new Intent(getBaseContext(), IslandDrinksProductDetailsActivity.class);
                            islandDrinksProductDetailsIntent.putExtra(IslandDrinksShoppingCartHelper.PRODUCT_INDEX, 4);
                            startActivity(islandDrinksProductDetailsIntent);
                        }

                        if(item.title.equalsIgnoreCase("Pepsi"))
                        {
                            Intent islandDrinksProductDetailsIntent = new Intent(getBaseContext(), IslandDrinksProductDetailsActivity.class);
                            islandDrinksProductDetailsIntent.putExtra(IslandDrinksShoppingCartHelper.PRODUCT_INDEX, 5);
                            startActivity(islandDrinksProductDetailsIntent);
                        }

                        //if structure that checks each position in the dessert catalog for the item in the list view
                        //********** dessert products
                        if(item.title.equalsIgnoreCase("Brownie Overboard"))
                        {
                            Intent dessertProductDetailsIntent = new Intent(getBaseContext(), DessertProductDetailsActivity.class);
                            dessertProductDetailsIntent.putExtra(DessertShoppingCartHelper.PRODUCT_INDEX, 0);
                            startActivity(dessertProductDetailsIntent);

                        }



                        if(item.title.equalsIgnoreCase("Cracker Jack Banana Cheesecake"))
                        {
                            Intent dessertProductDetailsIntent = new Intent(getBaseContext(), DessertProductDetailsActivity.class);
                            dessertProductDetailsIntent.putExtra(DessertShoppingCartHelper.PRODUCT_INDEX, 1);
                            startActivity(dessertProductDetailsIntent);

                        }


                        if(item.title.equalsIgnoreCase("Hot Fudge Sundae"))
                        {
                            Intent dessertProductDetailsIntent = new Intent(getBaseContext(), DessertProductDetailsActivity.class);
                            dessertProductDetailsIntent.putExtra(DessertShoppingCartHelper.PRODUCT_INDEX, 2);
                            startActivity(dessertProductDetailsIntent);

                        }



                        if(item.title.equalsIgnoreCase("Apple Cheesecake"))
                        {
                            Intent dessertProductDetailsIntent = new Intent(getBaseContext(), DessertProductDetailsActivity.class);
                            dessertProductDetailsIntent.putExtra(DessertShoppingCartHelper.PRODUCT_INDEX, 3);
                            startActivity(dessertProductDetailsIntent);

                        }


                        if(item.title.equalsIgnoreCase("Churro S'Mores"))
                        {
                            Intent dessertProductDetailsIntent = new Intent(getBaseContext(), DessertProductDetailsActivity.class);
                            dessertProductDetailsIntent.putExtra(DessertShoppingCartHelper.PRODUCT_INDEX, 4);
                            startActivity(dessertProductDetailsIntent);

                        }


                        if(item.title.equalsIgnoreCase("Chocolate Cake"))
                        {
                            Intent dessertProductDetailsIntent = new Intent(getBaseContext(), DessertProductDetailsActivity.class);
                            dessertProductDetailsIntent.putExtra(DessertShoppingCartHelper.PRODUCT_INDEX, 5);
                            startActivity(dessertProductDetailsIntent);

                        }


                        //if structure that checks each position in the salad catalog for the item in the list view
                        //********** salad products
                        if(item.title.equalsIgnoreCase("New England Clam Chowder"))
                        {
                            Intent saladProductDetailsIntent = new Intent(getBaseContext(), SaladProductDetailsActivity.class);
                            saladProductDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, 0);
                            startActivity(saladProductDetailsIntent);


                        }

                        if(item.title.equalsIgnoreCase("Creamy Potato Bacon"))
                        {
                            Intent saladProductDetailsIntent = new Intent(getBaseContext(), SaladProductDetailsActivity.class);
                            saladProductDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, 1);
                            startActivity(saladProductDetailsIntent);
                        }


                        if(item.title.equalsIgnoreCase("Classic Caesar Salad"))
                        {
                            Intent saladProductDetailsIntent = new Intent(getBaseContext(), SaladProductDetailsActivity.class);
                            saladProductDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, 2);
                            startActivity(saladProductDetailsIntent);
                        }


                        if(item.title.equalsIgnoreCase("Lobster Bisque"))
                        {
                            Intent saladProductDetailsIntent = new Intent(getBaseContext(), SaladProductDetailsActivity.class);
                            saladProductDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, 3);
                            startActivity(saladProductDetailsIntent);
                        }


                        if(item.title.equalsIgnoreCase("Shrimp Salad"))
                        {
                            Intent saladProductDetailsIntent = new Intent(getBaseContext(), SaladProductDetailsActivity.class);
                            saladProductDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, 4);
                            startActivity(saladProductDetailsIntent);
                        }


                        if(item.title.equalsIgnoreCase("Fried Fish Sandwich"))
                        {
                            Intent saladProductDetailsIntent = new Intent(getBaseContext(), SaladProductDetailsActivity.class);
                            saladProductDetailsIntent.putExtra(SaladShoppingCartHelper.PRODUCT_INDEX, 5);
                            startActivity(saladProductDetailsIntent);
                        }


                    }


                });


        //empty shopping cart message displayed to the user if no items are in the shopping cart
        mergeAdapter.setNoItemsText("Your Shopping Cart is Empty. Please browse our menu and add your selections.");


        //when the add more items button is clicked, the categorized menu screen is opened
        addMoreItemsButton = (Button) findViewById(R.id.addmoreitems_button);
        addMoreItemsButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        ///creates an intent that displays or opens the screen with the restaurant's categorized menu
                        Intent menuScreenIntent = new Intent("com.example.tishay.acerestaurantapp.menu_screen_activity");

                        //opens the categorized menu screen
                        startActivity(menuScreenIntent);

                    }//end onClick()

                }//end View.OnClickListener()

        );//end addMoreItemsButton.setOnClickListener

        //when the checkout button is clicked, the checkout screen is opened
        checkoutButton = (Button) findViewById(R.id.checkout_button);
        checkoutButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //if nothing is in the shopping cart, notify the user
                        if (subtotal <= 0)
                        {
                            Toast.makeText(getBaseContext(),
                                    "Please browse our menu and make a selection(s) before checking out.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        //if items are in the shopping cart display the checkout screen
                        else {
                            //creates an intent that displays or opens the checkout screen
                            Intent checkoutScreenIntent = new Intent("com.example.tishay.acerestaurantapp.SubmitOrderActivity");

                            //opens the checkout screen
                            startActivity(checkoutScreenIntent);
                        }

                    }//end onClick()


                }//end View.OnClickListener()


        );//end checkoutButton.setOnClickListener

        //calculates the total price of fine dining items added to cart
        for(Product p : fineDiningCartList) {
            int quantity = FineDiningShoppingCartHelper.getProductQuantity(p);
            fineDiningSubTotal += p.price * quantity;
        }


        //calculates the total price of sea food items added to cart
        for(Product p : seaFoodCartList) {
            int quantity = SeaFoodShoppingCartHelper.getProductQuantity(p);
            seaFoodSubTotal += p.price * quantity;
        }

        //calculates the total price of island flavor items added to cart
        for(Product p : islandFlavorCartList) {
            int quantity = IslandFlavorShoppingCartHelper.getProductQuantity(p);
            islandFlavorSubTotal += p.price * quantity;
        }

        //calculates the total price pof island drinks items added to cart
        for(Product p : islandDrinksCartList) {
            int quantity = IslandDrinksShoppingCartHelper.getProductQuantity(p);
            islandDrinksSubTotal += p.price * quantity;
        }

        //calculates the total price of fine dining items added to cart
        for(Product p : dessertCartList) {
            int quantity = DessertShoppingCartHelper.getProductQuantity(p);
            dessertSubTotal += p.price * quantity;
        }

        //calculates the total price of fine dining items added to cart
        for(Product p : saladCartList) {
            int quantity = SaladShoppingCartHelper.getProductQuantity(p);
            saladSubTotal += p.price * quantity;
        }

        //calculates total of all items in cart
        subtotal = fineDiningSubTotal + seaFoodSubTotal + islandFlavorSubTotal + islandDrinksSubTotal + dessertSubTotal + saladSubTotal;

        productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
        productPriceTextView.setText (String.format("Total: $%.2f", subtotal));

    }//end onCreate


    @Override
    protected void onResume() {
        super.onResume();


        // Refresh the data
        if(fineDiningProductAdapter != null) {
            fineDiningProductAdapter.notifyDataSetChanged();

        }

        // Refresh the data
        if(seaFoodProductAdapter != null) {
            seaFoodProductAdapter.notifyDataSetChanged();

        }

        // Refresh the data
        if(islandFlavorProductAdapter != null) {
            islandFlavorProductAdapter.notifyDataSetChanged();

        }

        // Refresh the data
        if(islandDrinksProductAdapter != null) {
            islandDrinksProductAdapter.notifyDataSetChanged();

        }

        // Refresh the data
        if(dessertProductAdapter != null) {
            dessertProductAdapter.notifyDataSetChanged();


        }

        // Refresh the data
        if(saladProductAdapter != null) {
            saladProductAdapter.notifyDataSetChanged();


        }

        // Refresh the data
        if(mergeAdapter != null) {
            mergeAdapter.notifyDataSetChanged();

        }




    }//end onResume()


}//end class ShoppingCartActivity