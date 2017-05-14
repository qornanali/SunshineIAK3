package com.example.sunshineiak3.data.model;

import java.util.List;

/**
 * Created by qornanali on 4/29/17.
 */

public class Forecast {

    private List<Weather> weather;
    private List<Main> main;
    private List<Cloud> clouds;
    private List<Wind> wind;
    private String dt_txt;
    private String dt;

    public Forecast() {
    }

    public List<Main> getMain() {
        return main;
    }

    public void setMain(List<Main> main) {
        this.main = main;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public List<Wind> getWind() {
        return wind;
    }

    public void setWind(List<Wind> wind) {
        this.wind = wind;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

}
