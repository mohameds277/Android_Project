package com.example.travel_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_in extends AppCompatActivity {


    TextView email;
    TextView password;
    Button sign_in_in;
    Intent home_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (TextView) findViewById(R.id.editTextTextPersonName);
        password = (TextView) findViewById(R.id.editTextTextPassword);
        sign_in_in = (Button) findViewById(R.id.button);

        sign_in_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_activity = new Intent(Sign_in.this, Home.class);
                startActivity(home_activity);


            }
        });
    }
}