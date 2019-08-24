package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    EditText btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        ButterKnife.bind(this);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valid()){

                }
            }
        });
    }

    public boolean valid() {
        if (txtName.getText().toString().equals("")) {
            txtName.setError("Enter your name correctly");
            return false;
        }else if (txtAddress.getText().toString().equals("")) {
            txtAddress.setError("Enter your address correctly");
            return false;
        }else if (txtContact.getText().toString().equals("")) {
            txtContact.setError("Enter your phone number correctly");
            return false;
        }else if (txtEmail.getText().toString().equals("")) {
            txtEmail.setError("Enter your email correctly");
            return false;
        }else if (txtUsername.getText().toString().equals("")) {
            txtUsername.setError("Enter your username correctly");
            return false;
        }else if (txtPass.getText().toString().equals("")) {
            txtPass.setError("Enter your password correctly");
            return false;
        }else if (!txtRepass.getText().toString().equals(txtPass.getText().toString())) {
            txtName.setError("Re enter your password correctly");
            return false;
        }


        return true;
    }
}
