package edu.feicui.sunshine.bean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class PM25Bean {
    public String city_name;//城市
    public String dateTime;//发布时间
    public String curPm;//污染指数
    public String pm25;
    public String pm10;
    public String quality;//污染等级
    public String des;//详细介绍

    public PM25Bean(String city_name, String dateTime, String curPm, String pm25,
                    String pm10, String quality, String des) {
        this.city_name = city_name;
        this.dateTime = dateTime;
        this.curPm = curPm;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.quality = quality;
        this.des = des;
    }

    @Override
    public String toString() {
        return city_name + dateTime + curPm + pm25 + pm10 + quality + des;
    }
}
