package com.example.sunshineiak3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sunshineiak3.data.model.Forecast;
import com.example.sunshineiak3.data.model.Weather;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvWeathers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWeathers = (RecyclerView) findViewById(R.id.rv_weathers);
        rvWeathers.setLayoutManager(new LinearLayoutManager(this));

        RequestQueue varRequestQueue = Volley.newRequestQueue(this);
        String varUrl = "http://api.openweathermap.org/data/2.5/forecast?q=Bandung&appid=76e4c41b9a2ca1ffe283f667a6529896";

        JsonObjectRequest varJsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET,
                        varUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        com.example.sunshineiak3.data.model.Response
                                responseResult = gson.fromJson
                                (response.toString(),
                                        com.example.sunshineiak3.data.model.Response.class);
                        rvWeathers.setAdapter(new WeatherListAdapter(getWeathers(responseResult)));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        varRequestQueue.add(varJsonObjectRequest);
    }

    private List<Weather> getWeathers(com.example.sunshineiak3.data.model.Response response){
        List<Weather> weatherList = new ArrayList<>();

        //ini for each
        for(Forecast forecast : response.getList()){
            for(Weather weather : forecast.getWeather()){
                weatherList.add(weather);
            }
        }

        return weatherList;
    }
}


