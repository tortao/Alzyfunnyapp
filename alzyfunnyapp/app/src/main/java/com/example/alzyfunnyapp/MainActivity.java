package com.example.alzyfunnyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageButton user;
    ImageButton contact;
    ImageButton about;
    ImageButton arcade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = (ImageButton) findViewById(R.id.user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PopuserActivity.class);
                startActivity(i);

            }
        });

        contact = (ImageButton) findViewById(R.id.contact);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PopcontactActivity.class);
                startActivity(i);
            }
        });

        about = (ImageButton) findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PopaboutActivity.class);
                startActivity(i);
            }
        });

        arcade = (ImageButton) findViewById(R.id.arcade);

        arcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });


    }
}






