package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Login_Form extends AppCompatActivity {

    Preference preference;
    User user;


    @BindView(R.id.txtUsername)
    EditText txtUsername;
    @BindView(R.id.txtPass)
    EditText txtPass;
    @BindView(R.id.btnReg)
    Button btnReg;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = new Preference(this);
        user = new Gson().fromJson(preference.getUser(), User.class);
        if (preference.isLoggedIn()) {
            startActivity(new Intent(Login_Form.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login__form);
<<<<<<< HEAD

        button1=(Button) findViewById(R.id.btn2);
        button2=(Button) findViewById(R.id.btn1);

        button1.setOnClickListener(new View.OnClickListener() {
=======
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
>>>>>>> c52ee531bbdcbf5e1c3e71aa2bdc6a37b0ed4a1a
            @Override
            public void onClick(View view) {
                if (user == null) {
                    Toast.makeText(getApplicationContext(), "No user found", Toast.LENGTH_SHORT).show();
                } else {
                    if (!user.getUsername().equals(txtUsername.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_SHORT).show();
                    } else if (!user.getPassword().equals(txtPass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
                    } else {
                        preference.setLoggedIn(true);
                        startActivity(new Intent(Login_Form.this, MainActivity.class));
                        finish();
                    }
                }
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Form.this, Signup_Form.class));
            }
        });
    }


}
