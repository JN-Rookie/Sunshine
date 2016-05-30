package edu.feicui.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.feicui.sunshine.bean.WeatherInfoBean;
import edu.feicui.sunshine.bean.WeekWeatherinfobean;
import edu.feicui.sunshine.utils.ImageUtils;
import edu.feicui.sunshine.utils.Jsonutils;

public class WeekWeatherInfoActivity extends AppCompatActivity {
    private TextView  date;//日期
    private TextView  weather_day;//白天天气
    private TextView  temperature_day;//白天温度
    private TextView  direct_day;//白天风向
    private TextView  power_day;//白天风级
    private TextView  sun_up;//日出时间
    private TextView  weather_night;//夜间天气
    private TextView  temperature_night;//夜间温度
    private TextView  direct_night;//夜间风向
    private TextView  power_night;//夜间风级
    private TextView  sun_down;//日落时间
    private TextView  week;//星期
    private TextView  moon;//农历日期
    private ImageView id_day;
    private ImageView id_night;
    private int       id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        initView();
        initData();
    }

    private void initData() {
        WeekWeatherinfobean data = Jsonutils.getJsonWeather().get(id);
        date.setText(data.date);//日期
        weather_day.setText(data.weather_day);//天气
        temperature_day.setText(data.temperature_day );//温度
        direct_day.setText(data.direct_day);//风向
        power_day.setText(data.power_day);//风级
        sun_up.setText("日出时间:  " + data.sun_up);//太阳升起
        weather_night.setText(data.weather_night);//天气
        temperature_night.setText(data.temperature_night );//温度
        direct_night.setText(data.direct_night);//风向
        power_night.setText(data.power_night);//风级
        sun_down.setText("日落时间:  " + data.sun_down);//降落
        week.setText("星期" + data.week);//星期
        moon.setText("农历" + data.moon);//农历日期
        id_day.setImageResource(ImageUtils.getImageDay(data.id_day));
        id_night.setImageResource(ImageUtils.getImageNight(data.id_night));
    }

    private void initView() {
        id = getIntent().getIntExtra("id", 0);//获取对应天气item的id值
        date = (TextView) findViewById(R.id.tv_date);//日期
        weather_day = (TextView) findViewById(R.id.tv_weather_day);//天气
        temperature_day = (TextView) findViewById(R.id.tv_temperature_day);
        direct_day = (TextView) findViewById(R.id.tv_direct_day);//风向
        power_day = (TextView) findViewById(R.id.tv_power_day);//风级
        sun_up = (TextView) findViewById(R.id.tv_sun_up);//太阳升起
        weather_night = (TextView) findViewById(R.id.tv_weather_night);//
        temperature_night = (TextView) findViewById(R.id.tv_temperature_night);
        direct_night = (TextView) findViewById(R.id.tv_direct_night);//风
        power_night = (TextView) findViewById(R.id.tv_power_night);//风级
        sun_down = (TextView) findViewById(R.id.tv_sun_down);//降落
        week = (TextView) findViewById(R.id.tv_week);//星期
        moon = (TextView) findViewById(R.id.tv_moon);//农历日期
        id_day = (ImageView) findViewById(R.id.iv_image_day);
        id_night = (ImageView) findViewById(R.id.iv_image_night);
    }

}
