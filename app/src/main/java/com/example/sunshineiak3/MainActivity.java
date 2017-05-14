package com.example.sunshineiak3;

import android.provider.CalendarContract;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvWeathers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String tanggal = "2017-05-14 06:00:00";
        try {
            Date datenow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tanggal);
            Calendar calNow = Calendar.getInstance();
            calNow.setTime(datenow);

            int month = calNow.get(Calendar.MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        rvWeathers = (RecyclerView) findViewById(R.id.rv_weathers);
        rvWeathers.setLayoutManager(new LinearLayoutManager(this));

        RequestQueue varRequestQueue = Volley.newRequestQueue(this);
        String varApiKey = "76e4c41b9a2ca1ffe283f667a6529896";
        String varEndPoint = "http://api.openweathermap.org/data/2.5/forecast?q=Bandung&appid="+varApiKey;

        JsonObjectRequest varJsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET,
                        varEndPoint, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        com.example.sunshineiak3.data.model.Response
                                responseResult = gson.fromJson
                                (response.toString(),
                                        com.example.sunshineiak3.data.model.Response.class);
                        WeatherListAdapter adapter = new WeatherListAdapter(responseResult.getList());
                        rvWeathers.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        varRequestQueue.add(varJsonObjectRequest);
    }
//
//    private List<Forecast> getForecasts(com.example.sunshineiak3.data.model.Response response){
//        List<Forecast> forecastList = new ArrayList<>();
//
//        //ini for each
//        for(Forecast forecast : response.getList()){
//            forecastList.add(forecast);
//        }
//
//        return forecastList;
//    }
}


