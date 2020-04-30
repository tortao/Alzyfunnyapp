package com.example.alzyfunnyapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;


public class PopuserActivity extends Activity {

    DatabaseReference myRef;
    EditText txt_name,txt_age;
    ImageButton btn_add,btn_update;
    ImageButton closeuser;
    Member member;
    RadioButton male,female;
    RadioGroup gender_group;

    long maxid = 0;

    String gender = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popuser);

        //Popup//

        closeuser = (ImageButton) findViewById(R.id.closeuser);

        closeuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


        //Firebase Database//

        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_age = (EditText) findViewById(R.id.txt_age);
        btn_add = (ImageButton) findViewById(R.id.btn_add);
        btn_update = (ImageButton)findViewById(R.id.btn_update);
        gender_group = (RadioGroup) findViewById(R.id.gender_group);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        member = new Member();

        myRef = FirebaseDatabase.getInstance().getReference().child("Member");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //AddDatabase//

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Age = Integer.parseInt(txt_age.getText().toString().trim());

                member.setName(txt_name.getText().toString().trim());
                member.setAge(Age);

                if(male.isChecked()){
                    gender = "Male";
                }
                if (female.isChecked()){
                     gender = "Female";
                }

                member.setGender(gender.trim());
                myRef.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(PopuserActivity.this,"Data Insert Successfully",Toast.LENGTH_LONG).show();
            }
        });

        //UpdateDatabase//

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String Name = dataSnapshot.child("name").getValue().toString();
                        String Age = dataSnapshot.child("age").getValue().toString();

                        txt_name.setText(Name);
                        txt_age.setText(Age);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}

