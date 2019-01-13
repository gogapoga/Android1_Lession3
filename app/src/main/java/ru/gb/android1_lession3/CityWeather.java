package ru.gb.android1_lession3;

import java.io.Serializable;

public class CityWeather implements Serializable {

    private String name;
    private int[] temp;
    private int[] humidity;
    private int[] pressure;
    private int[] wind;
    private Boolean init;

    public CityWeather(String name) {
        this.name = name;
        init = false;
    }
    public void loadWeather() {  // загрузка погоды для города, пока случайным образом
        temp = new int[24];
        humidity = new int[24];
        pressure = new int[24];
        wind = new int[24];
        for(int i = 0; i < 24; i++) {
            temp[i] = (int)(Math.random() * 10) - 5;
            humidity[i] = (int)(Math.random() * 50) + 30;
            pressure[i] = (int)(Math.random() * 50) + 725;
            wind[i] = (int)(Math.random() * 25) + 1;
        }
        init = true;
    }
    public String getName() {
        return name;
    }
    public String getWind(int time) {
        return init ? String.valueOf(wind[time]) + " м/с" : "нет данных";
    }
    public String getHumidity(int time) {
        return init ? String.valueOf(humidity[time]) + "%" : "нет данных";
    }
    public String getPressure(int time) {
        return init ? String.valueOf(pressure[time]) + " мм.рт.ст." : "нет данных";
    }
    public String getTemp(int time) {
        return init ? String.valueOf(temp[time]) + " °C" : "нет данных";
    }
}
