package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.onlineshopping.Helper.Preference;
import com.example.onlineshopping.Model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Customer_Profile extends AppCompatActivity {
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtAddress)
    TextView txtAddress;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtContact)
    TextView txtContact;

    Preference preference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__profile);
        ButterKnife.bind(this);
        preference = new Preference(this);
        user = new Gson().fromJson(preference.getUser(), User.class);

        txtName.setText("Name: " + user.getName());
        txtName.setText("Address: " + user.getAddress());
        txtName.setText("Email: " + user.getEmail());
        txtName.setText("Contact: " + user.getContact());
    }
}
