package ru.gb.android1_lession3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CityWeatherActivity extends AppCompatActivity {

    private Boolean showWind;
    private Boolean showHumidity;
    private Boolean showPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        Bundle bundle = getIntent().getExtras();
        showWind = bundle.getBoolean(Param.ShowWind.toString());
        showHumidity = bundle.getBoolean(Param.ShowHumidity.toString());
        showPressure = bundle.getBoolean(Param.ShowPressure.toString());
        CityWeather city = (CityWeather)bundle.getSerializable(Param.CityWeather.toString());
        setTitle(makeTitle(city.getName()));
        LinearLayout timeweather = (LinearLayout) findViewById(R.id.timeweather);
        for(int i = 0; i < 24; i++) {
            Button timeWeather = new Button(this);
            timeWeather.setClickable(false);
            timeWeather.setGravity(Gravity.LEFT | Gravity.TOP);
            StringBuilder str = new StringBuilder("Время: ");
            str.append(i);
            str.append(":00\n");
            str.append("Температура: ");
            str.append(city.getTemp(i));
            if(showHumidity) {
                str.append("\n");
                str.append("Влажность: ");
                str.append(city.getHumidity(i));
            }
            if(showWind) {
                str.append("\n");
                str.append("Ветер: ");
                str.append(city.getWind(i));
            }
            if(showPressure) {
                str.append("\n");
                str.append("Давление: ");
                str.append(city.getPressure(i));
            }
            timeWeather.setText(str);
            timeweather.addView(timeWeather);
        }
    }
    private String makeTitle(String cityName) {
        StringBuilder str = new StringBuilder("");
        str.append(cityName);
        str.append("     ");
        SimpleDateFormat sdf = new SimpleDateFormat("E  d MMM", Locale.forLanguageTag("ru-RU"));
        str.append(sdf.format(Calendar.getInstance().getTime()));
        return str.toString();
    }
}
