package com.example.foodapplication;

import android.content.Context;
import android.util.Log;

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
    String ACCESS_TOKEN = "Basic YWNjX2VjNmNlYWU5MDc3MGY2Yzo2NmI3OTg4NTcwN2FiNGRmZmUxNTg0Mjc0YWIzYjI2ZQ==";

    public JSONObject restCall(final String url) {
        String API_ENDPOINT = "https://api.imagga.com/v2/tags";
        StringRequest request = new StringRequest(Request.Method.POST, API_ENDPOINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.equals(null)) {
                    Log.e("Your Array Response", response);
                } else {
                    Log.e("Your Array Response", "Data Null");
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error is ", "" + error);
            }
        }) {

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", ACCESS_TOKEN);
                return params;
            }

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("image_url", url);
                return params;
            }

        };
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        JSONObject jsonResponse = new JSONObject();
        return  jsonResponse;
    }

}
