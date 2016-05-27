package edu.feicui.sunshine.bean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class WeatherInfoBean {
    public String direct;//风向
    public String power;//风级
    public String time;//更新时间
    public String humidity;//湿度
    public String info;//天气
    public String temperature;//温度
    public String date;//日期
    public String city_name;//地区
    public String week;//星期
    public String moon;//农历日期
    public int    id;

    public WeatherInfoBean() {
    }

    public WeatherInfoBean(String direct, String power, String time, String humidity,
                           String info, String temperature, String data, String city_name,
                           String week, String moon, int id) {
        this.direct = direct;
        this.power = power;
        this.time = time;
        this.humidity = humidity;
        this.info = info;
        this.temperature = temperature;
        this.date = data;
        this.city_name = city_name;
        this.week = week;
        this.moon = moon;
        this.id = id;
    }

    @Override
    public String toString() {
        return direct + power + time + humidity + info + temperature + date + city_name + week + moon;
    }
}

