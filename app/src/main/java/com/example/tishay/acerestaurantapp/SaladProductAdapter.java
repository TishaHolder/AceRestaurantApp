/**
 * IT633 : Mobile Application Development
 * Final Project Part I Milesone One: FineDiningProductAdapter.java
 * Populates the data for the fine dining products in the list view.
 * Student: Tisha Holder
 * Instructor: Venkatesh Baglodi
 * Due Date: September 11, 2016
 **/

package com.example.tishay.acerestaurantapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SaladProductAdapter extends BaseAdapter
{

    private List<Product> mProductList;//stores the list of products to display in the shopping cart and catalog
    private LayoutInflater mInflater;//instantiate layout XML file
    private boolean mShowQuantity;//boolean value that indicates whether to show the quantity in the shopping cart or catalog
    private boolean mShowPrice;//boolean value that indicates whether to show the price in the shopping cart or catalog

    //constructor
    public SaladProductAdapter(List<Product> list, LayoutInflater inflater, boolean showQuantity, boolean showPrice) {
        mProductList = list;
        mInflater = inflater;
        mShowQuantity = showQuantity;
        mShowPrice = showPrice;
    }

    //getters
    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

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

            //sets the title in both the catalog and shopping cart
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

        Product curProduct = mProductList.get(position);

        item.productImageView.setImageDrawable(curProduct.productImage);
        item.productTitle.setText(curProduct.title);

        int product_quantity = SaladShoppingCartHelper.getProductQuantity(curProduct);
        double product_price = curProduct.price;

        //if the user hasn't added any products from the fine dining category to their shopping cart, set the quantity to one (for calculation purposes)
        //if(SaladShoppingCartHelper.getProductQuantity(curProduct) == 0)
        //{
           // product_quantity = 1;
        //}

        //item.productPrice.setText (String.format("$%.2f", (product_price * product_quantity)));

        // Show the quantity in the cart or not
        if (mShowQuantity)
        {
            item.productQuantity.setText("Quantity: "
                    + SaladShoppingCartHelper.getProductQuantity(curProduct));
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

