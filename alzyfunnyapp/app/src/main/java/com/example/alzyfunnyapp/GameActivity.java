package com.example.alzyfunnyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {


    ImageButton btn_home;
    ImageButton btn_memomatch;
    ImageButton btn_memo2048;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_memomatch = (ImageButton) findViewById(R.id.btn_memomatch);
        btn_memo2048 = (ImageButton) findViewById(R.id.btn_memo2048);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
