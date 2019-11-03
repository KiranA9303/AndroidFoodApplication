package com.example.foodapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class FoodsPage extends AppCompatActivity {
    String userText;
    Context context = GlobalApplication.getAppContext();
    String errorString;
    String approxValue;
    String URL_1 = "https://res.cloudinary.com/dnyd3euyo/image/upload/v1572574921/avocado1_om6g31.jpg";
    String URL_2 = "https://res.cloudinary.com/dnyd3euyo/image/upload/v1572574921/pineapple_lsygdf.jpg";
    String URL_3 = "https://res.cloudinary.com/dnyd3euyo/image/upload/v1572479801/banana_cspv8j.jpg";
    String URL_4 = "https://res.cloudinary.com/dnyd3euyo/image/upload/v1572479801/orange_izibgw.jpg";
    String URL_5 = "https://res.cloudinary.com/dnyd3euyo/image/upload/v1572575147/strawberry1_n1twdd.jpg";
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
        android_image1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { restAPIMethod(URL_1,"320 "); }});
        ImageView android_image2 = (ImageView) findViewById(R.id.android_image2_jpg);
        android_image2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { restAPIMethod(URL_2,"680 "); }});
        ImageView android_image3 = (ImageView) findViewById(R.id.android_image3_jpg);
        android_image3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { restAPIMethod(URL_3,"230 "); }});
        ImageView android_image4 = (ImageView) findViewById(R.id.android_image4_jpg);
        android_image4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { restAPIMethod(URL_4,"180 "); }});
        ImageView android_image5 = (ImageView) findViewById(R.id.android_image5_jpg);
        android_image5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { restAPIMethod(URL_5,"40 "); }});
    }

    public void restAPIMethod(String url, String approxCalories){
        RequestAPIClass requestAPIClass = new RequestAPIClass();
        String respData = requestAPIClass.restCall(url);
        if(respData == null){
            errorString = url;
            approxValue = approxCalories;
            errorUtil();
        }
    }

    public void errorUtil(){
        if(errorString != null){
            Intent intent = new Intent(context ,ResponseTable.class);
            intent.putExtra("response", errorString);
            intent.putExtra("approxValue", approxValue);
            startActivity(intent);
        }
    }
}
