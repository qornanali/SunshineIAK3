package com.example.sunshineiak3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView varTvResponse = (TextView) findViewById(R.id.tv_response);

        RequestQueue varRequestQueue = Volley.newRequestQueue(this);
        String varUrl = "http://api.openweathermap.org/data/2.5/forecast?q=Bandung&appid=76e4c41b9a2ca1ffe283f667a6529896";

        StringRequest varStringRequest =
                new StringRequest(Request.Method.GET, varUrl,
                        new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //response dari API berhasil diambil
                        varTvResponse.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        varTvResponse.setText(error.getMessage());
                    }
                });
        varRequestQueue.add(varStringRequest);
    }
}
