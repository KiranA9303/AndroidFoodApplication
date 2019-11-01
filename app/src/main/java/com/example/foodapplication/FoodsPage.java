package com.example.foodapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodsPage extends AppCompatActivity {
    String userText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        userText = intent.getStringExtra("userText");
        TextView userLabel = (TextView) findViewById(R.id.usernameLabel);
        userLabel.setText(userText);



        addListenerOnFoodImages(userText);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addListenerOnFoodImages(String userText) {
        final String userLabel = userText;
        ImageView android_image1 = (ImageView) findViewById(R.id.android_image1_jpg);
        //ImageView food_logo = (ImageView) findViewById(R.id.food_logo);

        android_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("https://api.imagga.com/v2/tags?image_url=https://res.cloudinary.com/dnyd3euyo/image/upload/v1572574921/avocado1_om6g31.jpg");
                restAPIMethod("https://res.cloudinary.com/dnyd3euyo/image/upload/v1572574921/avocado1_om6g31.jpg");
            }
        });
    }

    public void restAPIMethod(String url){
        RequestAPIClass requestAPIClass = new RequestAPIClass();
        requestAPIClass.restCall(url);
    }

}
