package com.example.sunshineiak3.data.model;

import java.util.List;

/**
 * Created by qornanali on 4/29/17.
 */

public class Response {

    private String cod;
    private List<Forecast> list;

    public Response() {
    }

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

    @Override
    public String toString() {
        String resp = "Response{" +
                "cod='" + cod + '\'' +
                ", list=[";
        for(int i = 0; i < getList().size(); i++){
            resp += list.get(i).toString() + (i == getList().size()-1 ? "" : ",");
        }
        resp += "]}";
        return resp;
    }
}
