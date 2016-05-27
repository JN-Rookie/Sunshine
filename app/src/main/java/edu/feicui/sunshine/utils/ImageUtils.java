package edu.feicui.sunshine.utils;

import edu.feicui.sunshine.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ImageUtils {
    //白天天气图标
    private static final int[] image_day   = {R.mipmap.weather_day0, R.mipmap.weather_day1,
            R.mipmap.weather_day2, R.mipmap.weather_day3, R.mipmap.weather_day4,
            R.mipmap.weather_day5, R.mipmap.weather_day6, R.mipmap.weather_day7,
            R.mipmap.weather_day8, R.mipmap.weather_day9, R.mipmap.weather_day10,
            R.mipmap.weather_day11, R.mipmap.weather_day12, R.mipmap.weather_day13,
            R.mipmap.weather_day14, R.mipmap.weather_day15, R.mipmap.weather_day16,
            R.mipmap.weather_day17, R.mipmap.weather_day18, R.mipmap.weather_day19,
            R.mipmap.weather_day20, R.mipmap.weather_day21, R.mipmap.weather_day22,
            R.mipmap.weather_day23, R.mipmap.weather_day24, R.mipmap.weather_day25,
            R.mipmap.weather_day26, R.mipmap.weather_day27, R.mipmap.weather_day28,
            R.mipmap.weather_day29, R.mipmap.weather_day30, R.mipmap.weather_day31};
    //夜晚天气图标
    private static final int[] image_night = {R.mipmap.weather_night0, R.mipmap.weather_night1,
            R.mipmap.weather_night2, R.mipmap.weather_night3, R.mipmap.weather_night4,
            R.mipmap.weather_night5, R.mipmap.weather_night6, R.mipmap.weather_night7,
            R.mipmap.weather_night8, R.mipmap.weather_night9, R.mipmap.weather_night10,
            R.mipmap.weather_night11, R.mipmap.weather_night12, R.mipmap.weather_night13,
            R.mipmap.weather_night14, R.mipmap.weather_night15, R.mipmap.weather_night16,
            R.mipmap.weather_night17, R.mipmap.weather_night18, R.mipmap.weather_night19,
            R.mipmap.weather_night20, R.mipmap.weather_night21, R.mipmap.weather_night22,
            R.mipmap.weather_night23, R.mipmap.weather_night24, R.mipmap.weather_night25,
            R.mipmap.weather_night26, R.mipmap.weather_night27, R.mipmap.weather_night28,
            R.mipmap.weather_night29, R.mipmap.weather_night30, R.mipmap.weather_night31};

    /**
     * 根据天气代码获取天气图标
     */
    public static int getImageDay(int i) {
        int image = R.mipmap.weather_day0;
        if (i >= 0 & i < 32) {
            image = image_day[i];
        } else if (i == 53) {
            image = R.mipmap.weather_day53;
        }
        return image;
    }

    /**
     * 根据天气代码获取天气图标
     */
    public static int getImageNight(int i) {
        int image = R.mipmap.weather_night0;
        if (i >= 0 & i < 32) {
            image = image_night[i];
        } else if (i == 53) {
            image = R.mipmap.weather_night53;
        }
        return image;
    }
}
