package edu.feicui.sunshine.utils;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static edu.feicui.sunshine.utils.Jsonutils.getWeatherDataFromJson;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Httputils {
    private static final String TAG = "MainActivity";
    public static final String APPKEY = "c154ac325c8703a8cbfd7867265c3954";


    /**
     * 根据城市名获取天气数据
     */
    public static String getRequest(String cityname) {
        String rs = null;
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        HttpURLConnection urlConnection = null;
        String url = "http://op.juhe.cn/onebox/weather/query?";
        //拼接URL
        String uri = Uri.parse(url).buildUpon()
                .appendQueryParameter("cityname", cityname)//城市名
                .appendQueryParameter("dtype", "")//返回数据类型
                .appendQueryParameter("key", APPKEY)//APIKEY
                .build().toString();
        try {
            URL url1 = new URL(uri);
            urlConnection = (HttpURLConnection) url1.openConnection();//获取网络数据
            urlConnection.setRequestMethod("GET");//请求类型
            urlConnection.setConnectTimeout(5000);//超时时间
            InputStream in = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(in));
            String strRead;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead).append("\n");
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert urlConnection != null;
            urlConnection.disconnect();
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "getRequest: "+rs);
        return rs;
    }
}
