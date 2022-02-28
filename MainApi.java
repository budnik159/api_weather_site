package com.apisites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class MainApi {
    public static void main(String[] args) throws IOException {
        String key = "a368950020011479e78e8d534208353a";
        String city = "Perm";

        String urlSite = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key + "&units=metric";

        URL url = new URL(urlSite);
        Scanner sc = new Scanner(url.openStream());
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        String jsonString = sb.toString();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Root root = gson.fromJson(jsonString, Root.class);

        System.out.println(root.main.temp);
    }
}

class Coord{
    public double lon;
    public double lat;
}

class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}

class Main{
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;
}

class Wind{
    public int speed;
    public int deg;
}

class Clouds{
    public int all;
}

class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}

class Root{
    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;
}
