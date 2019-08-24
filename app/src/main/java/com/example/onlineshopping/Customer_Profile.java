package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
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
        txtAddress.setText("Address: " + user.getAddress());
        txtEmail.setText("Email: " + user.getEmail());
        txtContact.setText("Contact: " + user.getContact());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
