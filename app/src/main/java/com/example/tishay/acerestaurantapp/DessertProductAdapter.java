package com.example.tishay.acerestaurantapp;

/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: DessertProductAdapter.java
 * Populates the data for the fine dining products in the list view.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DessertProductAdapter extends BaseAdapter
{

    private List<Product> mProductList;//stores the list of products to display in the shopping cart and catalog
    private LayoutInflater mInflater;//instantiate layout XML file
    private boolean mShowQuantity;//boolean value that indicates whether to show the quantity in the shopping cart or catalog
    private boolean mShowPrice;//boolean value that indicates whether to show the price in the shopping cart or catalog


    //constructor initializes instance variables
    public DessertProductAdapter(List<Product> list, LayoutInflater inflater, boolean showQuantity, boolean showPrice) {
        mProductList = list;
        mInflater = inflater;
        mShowQuantity = showQuantity;
        mShowPrice = showPrice;
    }

    //getCount()
    @Override
    public int getCount() {
        return mProductList.size();
    }

    //getItem()
    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    //getItemId()
    @Override
    public long getItemId(int position) {
        return position;
    }

    //getView()
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewItem item;

        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item, null);
            item = new ViewItem();

            //sets the image in both the catalog and shopping cart
            item.productImageView = (ImageView) convertView
                    .findViewById(R.id.ImageViewItem);

            //sets the image in both the catalog and shopping cart
            item.productTitle = (TextView) convertView
                    .findViewById(R.id.TextViewItem);

            //sets the price in both the catalog and shopping cart
            item.productPrice = (TextView) convertView
                    .findViewById(R.id.TextViewPrice);

            //sets the quantity in both the catalog and shopping cart
            item.productQuantity = (TextView) convertView
                    .findViewById(R.id.textViewQuantity);

            convertView.setTag(item);

        } //end if
        else
        {
            item = (ViewItem) convertView.getTag();

        }//end else

        Product curProduct = mProductList.get(position);//creates current product

        item.productImageView.setImageDrawable(curProduct.productImage);//sets the image of the current product
        item.productTitle.setText(curProduct.title);//sets the title of the current product

        int product_quantity = DessertShoppingCartHelper.getProductQuantity(curProduct);//stores the current product quantity
        double product_price = curProduct.price;//stores the product price

        //if the user hasn't added any products from the dessert category to their shopping cart, set the quantity to one (for calculation purposes)
        //if(DessertShoppingCartHelper.getProductQuantity(curProduct) == 0)
        //{
            //product_quantity = 1;
        //}

        //multiplies the number of items added to the cart by the price of the item
        //item.productPrice.setText (String.format("$%.2f", (product_price * product_quantity)));

        // determine whether the item quantity is shown in the catalog or shopping cart
        if (mShowQuantity)
        {
            item.productQuantity.setText("Quantity: "
                    + DessertShoppingCartHelper.getProductQuantity(curProduct));
        } else {
            // Hide the view
            item.productQuantity.setVisibility(View.GONE);
        }

        // Show the price in the cart or not
        if (mShowPrice)
        {
            //multiplies the number of items added to the cart by the price of the item
            item.productPrice.setText (String.format("$%.2f", (product_price * product_quantity)));

        } else {
            // Hide the view
            item.productPrice.setVisibility(View.GONE);
        }

        return convertView;
    }

    private class ViewItem
    {
        ImageView productImageView;
        TextView productTitle;
        TextView productPrice;
        TextView productQuantity;

    }//end class ViewItem()

}//end class FineDiningProductAdapter

