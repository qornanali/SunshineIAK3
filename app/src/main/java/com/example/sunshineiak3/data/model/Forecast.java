package com.example.sunshineiak3.data.model;

import java.util.List;

/**
 * Created by qornanali on 4/29/17.
 */

public class Forecast {

    private List<Weather> weather;

    public Forecast(List<Weather> weather) {
        this.weather = weather;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
