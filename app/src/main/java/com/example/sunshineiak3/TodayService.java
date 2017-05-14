package com.example.sunshineiak3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
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

import java.util.List;

/**
 * Created by qornanali on 5/14/17.
 */

public class TodayService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        getTodayData();
    }

    private void getTodayData(){
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
                        List<Forecast> forecastList = responseResult.getList();
                        List<Weather> weatherList = forecastList.get(0).getWeather();
                        Weather today = weatherList.get(0);
                        Toast.makeText(TodayService.this, today.getDescription(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        varRequestQueue.add(varJsonObjectRequest);
    }
}
