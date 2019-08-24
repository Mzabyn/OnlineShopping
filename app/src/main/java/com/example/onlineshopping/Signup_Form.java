package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshopping.Helper.Preference;
import com.example.onlineshopping.Model.User;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Signup_Form extends AppCompatActivity {
    @BindView(R.id.txtName)
    EditText txtName;

    @BindView(R.id.txtAddress)
    EditText txtAddress;

    @BindView(R.id.txtContact)
    EditText txtContact;


    @BindView(R.id.txtEmail)
    EditText txtEmail;

    @BindView(R.id.txtPass)
    EditText txtPass;

    @BindView(R.id.txtRepass)
    EditText txtRepass;

    @BindView(R.id.txtUsername)
    EditText txtUsername;

    @BindView(R.id.btn3)
    Button btn3;

    Preference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        ButterKnife.bind(this);
        preference = new Preference(this);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()) {
                    User u = new User(txtName.getText().toString(),
                            txtAddress.getText().toString(),
                            txtEmail.getText().toString(),
                            txtContact.getText().toString(),
                            txtUsername.getText().toString(),
                            txtPass.getText().toString());
                    preference.setUser(new Gson().toJson(u));
                    Toast.makeText(getApplicationContext(), "Registration Completed Successfully", Toast.LENGTH_SHORT).show();
                    preference.setLoggedIn(true);
                    startActivity(new Intent(Signup_Form.this, MainActivity.class));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        finishAffinity();
                    }
                }
            }
        });
    }

    public boolean valid() {
        if (txtName.getText().toString().equals("")) {
            txtName.setError("Enter your name correctly");
            return false;
        } else if (txtAddress.getText().toString().equals("")) {
            txtAddress.setError("Enter your address correctly");
            return false;
        } else if (txtContact.getText().toString().equals("")) {
            txtContact.setError("Enter your phone number correctly");
            return false;
        } else if (txtEmail.getText().toString().equals("")) {
            txtEmail.setError("Enter your email correctly");
            return false;
        } else if (txtUsername.getText().toString().equals("")) {
            txtUsername.setError("Enter your username correctly");
            return false;
        } else if (txtPass.getText().toString().equals("")) {
            txtPass.setError("Enter your password correctly");
            return false;
        } else if (!txtRepass.getText().toString().equals(txtPass.getText().toString())) {
            txtName.setError("Re enter your password correctly");
            return false;
        }
        return true;
    }
}
