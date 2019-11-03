package com.example.foodapplication;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;


public class RequestAPIClass {
    Context context = GlobalApplication.getAppContext();
    FoodsPage foodsPage = new FoodsPage();
    String ACCESS_TOKEN = "YWNjX2VjNmNlYWU5MDc3MGY2Yzo2NmI3OTg4NTcwN2FiNGRmZmUxNTg0Mjc0YWIzYjI2ZQ==";
    String responseData;
    String errorUrl = "";

    public String restCall(final String url) {
        String API_ENDPOINT = "https://api.imagga.com/v2/tags?image_url=https://res.cloudinary.com/dnyd3euyo/image/upload/v1572574921/avocado1_om6g31.jpg";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, API_ENDPOINT, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseJsonObject = new JSONObject(response);
                    if (!responseJsonObject.equals(null)) {
                        responseData = responseJsonObject.toString();

                    } else {
                        Log.e("Your Array Response", "Data Null");
                    }
                } catch (JSONException e) {
                    Log.e("JSonErr", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(" inside the error block");
            }
        })

        {

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Basic YWNjX2VjNmNlYWU5MDc3MGY2Yzo2NmI3OTg4NTcwN2FiNGRmZmUxNTg0Mjc0YWIzYjI2ZQ==");
                return headers;
            }
        };
        //RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        return responseData;
    }

    void handleTheError(){
        responseData = errorUrl;
    }

}
