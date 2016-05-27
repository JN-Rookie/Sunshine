package edu.feicui.sunshine.bean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class WeekWeatherinfobean {
    public String date;//日期
    public String weather_day;//天气
    public String temperature_day;//温度
    public String direct_day;//风向
    public String power_day;//风级
    public String sun_up;//太阳升起
    public String weather_night;//天气
    public String temperature_night;//温度
    public String direct_night;//风向
    public String power_night;//风级
    public String sun_down;//降落
    public String week;//星期
    public String moon;//农历日期
    public int    id_day;
    public int    id_night;

    public WeekWeatherinfobean() {
    }

    public WeekWeatherinfobean(String date, String weather_day, String temperature_day,
                               String direct_day, String power_day, String sun_up,
                               String weather_night, String temperature_night, String direct_night,
                               String power_night, String sun_down, String week, String moon,
                               int id_day, int id_night) {
        this.date = date;
        this.weather_day = weather_day;
        this.temperature_day = temperature_day;
        this.direct_day = direct_day;
        this.power_day = power_day;
        this.sun_up = sun_up;
        this.weather_night = weather_night;
        this.temperature_night = temperature_night;
        this.direct_night = direct_night;
        this.power_night = power_night;
        this.sun_down = sun_down;
        this.week = week;
        this.moon = moon;
        this.id_day = id_day;
        this.id_night = id_night;
    }

    @Override
    public String toString() {
        return date + weather_day + weather_night + temperature_day + temperature_night +
                direct_day + direct_night + power_day + power_night + sun_up + sun_down + week + moon;
    }
}

