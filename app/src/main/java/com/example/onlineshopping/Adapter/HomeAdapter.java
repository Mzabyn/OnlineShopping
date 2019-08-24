package com.example.onlineshopping.Adapter;

import android.graphics.Movie;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Model.Product;
import com.example.onlineshopping.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
        implements Filterable {

    private List<Product> productList;
    private List<Product> filteredProductList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, desc;
        ImageView product_image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.product_name);
            price = (TextView) view.findViewById(R.id.product_price);
            desc = (TextView) view.findViewById(R.id.desc);
            product_image = (ImageView) view.findViewById(R.id.product_image);
        }
    }


    public HomeAdapter(List<Product> productList) {
        this.productList = productList;
        this.filteredProductList = productList;
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

        Picasso.get()
                .load(product.getImage())
                .placeholder(android.R.drawable.gallery_thumb)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.product_image, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("Picasso:::", e.getMessage());
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