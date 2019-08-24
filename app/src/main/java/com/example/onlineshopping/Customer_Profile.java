package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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

    public void logOutAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(Customer_Profile.this).create();
        alertDialog.setTitle("Online Shopping");
        alertDialog.setMessage("Are you sure you want to log out ? ");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        preference.setLoggedIn(false);
                        startActivity(new Intent(Customer_Profile.this, Login_Form.class));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }

                    }
                });
        alertDialog.show();
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
            logOutAlert();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
