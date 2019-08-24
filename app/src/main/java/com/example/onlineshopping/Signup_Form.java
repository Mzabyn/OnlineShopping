package com.example.onlineshopping;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineshopping.R;

public class Signup_Form extends AppCompatActivity {


    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);

        button2=(Button) findViewById(R.id.btn3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(Signup_Form.this,Login_Form.class);
//                startActivity(intent);
            }
        });
    }
}
