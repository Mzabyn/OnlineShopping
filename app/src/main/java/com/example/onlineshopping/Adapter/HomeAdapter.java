package com.example.onlineshopping.Adapter;

import android.app.Activity;
import android.graphics.Movie;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Helper.Preference;
import com.example.onlineshopping.Model.Cart;
import com.example.onlineshopping.Model.Product;
import com.example.onlineshopping.R;
import com.google.gson.Gson;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
        implements Filterable {

    private List<Product> productList;
    private List<Product> filteredProductList;
    private List<Cart> cartList;
    Preference preference;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, desc;
        ImageView product_image;
        Button btn_cart;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.product_name);
            price = (TextView) view.findViewById(R.id.product_price);
            desc = (TextView) view.findViewById(R.id.desc);
            product_image = (ImageView) view.findViewById(R.id.product_image);
            btn_cart = (Button) view.findViewById(R.id.btn_cart);
        }
    }


    public HomeAdapter(List<Product> productList, List<Cart> cartList, Activity context) {
        this.productList = productList;
        this.filteredProductList = productList;
        this.cartList = cartList;
        preference = new Preference(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = filteredProductList.get(position);
        holder.name.setText(product.getProduct_name());
        holder.price.setText(product.getPrice() + " BDT");
        holder.desc.setText(product.getDetails());
        holder.btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                Cart c = new Cart(rand.nextInt(), product);
                cartList.add(c);
                preference.setCart(new Gson().toJson(cartList));
            }
        });
        Picasso.get().load(product.getImage())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.product_image, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        holder.product_image.setAlpha(0f);
                        holder.product_image.animate().setDuration(1000).alpha(1f).start();
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredProductList = productList;
                } else {
                    List<Product> filteredList = new ArrayList<>();
                    for (Product row : productList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getProduct_name().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    filteredProductList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredProductList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredProductList = (ArrayList<Product>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return filteredProductList.size();
    }
}