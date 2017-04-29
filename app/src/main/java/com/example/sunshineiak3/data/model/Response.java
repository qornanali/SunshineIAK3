package com.example.sunshineiak3.data.model;

import java.util.List;

/**
 * Created by qornanali on 4/29/17.
 */

public class Response {

    private String cod;
    private List<Forecast> list;

    public Response(String cod, List<Forecast> list) {
        this.cod = cod;
        this.list = list;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<Forecast> getList() {
        return list;
    }

    public void setList(List<Forecast> list) {
        this.list = list;
    }
}
