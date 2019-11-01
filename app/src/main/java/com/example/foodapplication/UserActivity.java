package com.example.foodapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    String userText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        userText = intent.getStringExtra("userText");
        TextView userLabel = (TextView) findViewById(R.id.usernameLabel);
        userLabel.setText(userText);



        addListenerOnLogoImages(userText);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addListenerOnLogoImages(String userText) {
        final String userLabel = userText;
        ImageView histroy_logo = (ImageView) findViewById(R.id.histroy_logo);
        ImageView food_logo = (ImageView) findViewById(R.id.food_logo);

        histroy_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Redirecting to History Page...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UserActivity.this,HistoryActivity.class);
                intent.putExtra("userText", userLabel);
                startActivity(intent);
            }
        });

        food_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Redirecting to Food Page...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UserActivity.this,FoodsPage.class);
                intent.putExtra("userText", userLabel);
                startActivity(intent);
            }
        });
    }

}
