package edu.feicui.sunshine.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.sunshine.bean.LifeBean;
import edu.feicui.sunshine.bean.PM25Bean;
import edu.feicui.sunshine.bean.WeatherInfoBean;
import edu.feicui.sunshine.bean.WeekWeatherinfobean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Jsonutils {
    private static final String TAG = "MainActivity";
    private static JSONObject jsonRealTime;
    private static JSONObject jsonLife;
    private static JSONArray  jsonWeather;
    private static JSONObject jsonPM25;

    /*
    根据城市名分析Json数据
     */
    public static void getWeatherDataFromJson(String jsonStr) {
        try {
            JSONObject json = new JSONObject(jsonStr);

            String str  = json.getString("reason");
            int    code = json.getInt("error_code");
            if (str.equals("成功") || str.equals("successed!") || code == 0) {//判断获取数据是否成功
                JSONObject jsonResult = json.getJSONObject("result");//json返回数据
                JSONObject jsonData = jsonResult.getJSONObject("data");//json返回数据
                jsonRealTime = jsonData.getJSONObject("realtime");//实时数据
                jsonLife = jsonData.getJSONObject("life");//生活指数
                jsonWeather = jsonData.getJSONArray("weather");//一周天气
                jsonPM25 = jsonData.getJSONObject("pm25");//PM25
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*
      解析实时数据
       */
    public static WeatherInfoBean getRealTime() {
        String windSpeed = null;
        String direct = null;//风向
        String power = null;//风级
        String time = null;//更新时间
        String humidity = null;//湿度
        String info = null;//天气
        String temperature = null;//温度
        String date = null;//日期
        String city_name = null;//地区
        String week = null;//星期
        String moon = null;//农历日期
        int id = -1;
        try {
            JSONObject wind = jsonRealTime.getJSONObject("wind");
            direct = wind.getString("direct");
            windSpeed = wind.getString("windspeed");
            power = wind.getString("power");
            time = jsonRealTime.getString("time");
            JSONObject weather = jsonRealTime.getJSONObject("weather");
            humidity = weather.getString("humidity");
            info = weather.getString("info");
            temperature = weather.getString("temperature");
            date = jsonRealTime.getString("date");
            city_name = jsonRealTime.getString("city_name");
            week = jsonRealTime.getString("week");
            moon = jsonRealTime.getString("moon");
            id = weather.getInt("img");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        WeatherInfoBean bean = new WeatherInfoBean(direct, power, time, humidity, info
                , temperature, date, city_name, week, moon, id);
        return bean;
    }

    /*
    解析生活指数
     */
    public static List<LifeBean> getJsonLife() {
        LifeBean lifeBean;
        List<LifeBean> bean = new ArrayList<>();
        String kongtiao = null;
        String yundong = null;
        String ziwaixian = null;
        String ganmao = null;
        String xiche = null;
        String wuran = null;
        String chuanyi = null;
        try {
            lifeBean = getString("kongtiao");
            lifeBean.title = "空调指数";
            bean.add(lifeBean);
            lifeBean = getString("yundong");
            lifeBean.title = "运动指数";
            bean.add(lifeBean);
            lifeBean = getString("ziwaixian");
            lifeBean.title = "紫外线指数";
            bean.add(lifeBean);
            lifeBean = getString("ganmao");
            lifeBean.title = "感冒指数";
            bean.add(lifeBean);
            lifeBean = getString("xiche");
            lifeBean.title = "洗车指数";
            bean.add(lifeBean);
            lifeBean = getString("wuran");
            lifeBean.title = "污染指数";
            bean.add(lifeBean);
            lifeBean = getString("chuanyi");
            lifeBean.title = "穿衣指数";
            bean.add(lifeBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /*
    根据KEY 获取生活指数详细信息
     */
    private static LifeBean getString(String key) throws JSONException {
        LifeBean bean;
        JSONObject info = jsonLife.getJSONObject("info");
        JSONArray jsonArray = info.getJSONArray(key);
        bean = new LifeBean(jsonArray.getString(0), jsonArray.getString(1));
        return bean;
    }

    /*
    获取未来一周天气数据
     */
    public static List<WeekWeatherinfobean> getJsonWeather() {
        List<WeekWeatherinfobean> bean = new ArrayList<>();//读取一周天气集合
        for (int i = 0; i < jsonWeather.length(); i++) {//for循环遍历读取信息
            String date = null;
            String weather_day = null;//天气
            String temperature_day = null;//温度
            String direct_day = null;//风向
            String power_day = null;//风级
            String sun_up = null;//太阳升起
            String weather_night = null;//天气
            String temperature_night = null;//温度
            String direct_night = null;//风向
            String power_night = null;//风级
            String sun_down = null;//降落
            String week = null;//星期
            String moon = null;//农历
            int id_day = -1;
            int id_night = -1;
            try {
                JSONObject data = jsonWeather.getJSONObject(i);
                JSONObject info = data.getJSONObject("info");
                JSONArray night = info.getJSONArray("night");
                JSONArray day = info.getJSONArray("day");
                date = data.getString("date");
                weather_day = day.getString(1);
                temperature_day = day.getString(2);
                direct_day = day.getString(3);
                power_day = day.getString(4);
                sun_up = day.getString(5);
                weather_night = night.getString(1);
                temperature_night = night.getString(2);
                direct_night = night.getString(3);
                power_night = night.getString(4);
                sun_down = night.getString(5);
                week = data.getString("week");
                moon = data.getString("nongli");
                id_day = day.getInt(0);
                id_night = night.getInt(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            WeekWeatherinfobean infoBean = new WeekWeatherinfobean(date, weather_day, temperature_day+ "℃",
                    direct_day, power_day, sun_up, weather_night, temperature_night+"℃",
                    direct_night, power_night, sun_down, "星期"+week, moon, id_day, id_night);
            bean.add(infoBean);
        }
        return bean;
    }

    /*
    获取PM2.5数据
     */
    public static PM25Bean getJsonPM25() {
        String city_name = null;//城市
        String date_time = null;//发布时间
        String curPm = null;//污染指数
        String pm25 = null;//
        String pm10 = null;//
        String quality = null;//污染等级
        String des = null;//详细介绍
        try {
            JSONObject json = jsonPM25.getJSONObject("pm25");
            city_name = jsonPM25.getString("cityName");
            date_time = jsonPM25.getString("dateTime");
            curPm = json.getString("curPm");
            pm25 = json.getString("pm25");
            pm10 = json.getString("pm10");
            quality = json.getString("quality");
            des = json.getString("des");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PM25Bean bean = new PM25Bean(city_name, date_time, curPm, pm25, pm10, quality, des);
        return bean;
    }
}
