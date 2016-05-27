package edu.feicui.sunshine;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.feicui.sunshine.bean.WeekWeatherinfobean;

/**
 * Created by Administrator on 2016/5/27.
 */
public class WeatherInfoAdapter extends BaseAdapter{
    private static final String TAG = "MainActivity";
    private List<WeekWeatherinfobean> data;
    private LayoutInflater mInflater;

    public WeatherInfoAdapter(Context context,List<WeekWeatherinfobean> data) {
        this.data = data;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(data!=null){
            return data.size();
        }
        return 0;
    }

    @Override
    public WeekWeatherinfobean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView==null){
            viewholder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.list_week_item,null);
            viewholder.date= (TextView) convertView.findViewById(R.id.tv_date_week);
            viewholder.week= (TextView) convertView.findViewById(R.id.tv_week);
            viewholder.weather= (TextView) convertView.findViewById(R.id.tv_weather_week);
            viewholder.tem= (TextView) convertView.findViewById(R.id.tv_tem_week);
            viewholder.wind= (TextView) convertView.findViewById(R.id.tv_wind_week);
            viewholder.power= (TextView) convertView.findViewById(R.id.tv_power_week);
            convertView.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) convertView.getTag();
        }
        WeekWeatherinfobean bean=data.get(position);
        viewholder.date.setText(bean.date);
        viewholder.week.setText(bean.week);
        viewholder.weather.setText(bean.weather_day);
        viewholder.tem.setText(bean.temperature_day);
        viewholder.wind.setText(bean.direct_day);
        viewholder.power.setText(bean.power_day);

        return convertView;
    }
    class ViewHolder{
        TextView date;
        TextView wind;
        TextView week;
        TextView tem;
        TextView weather;
        TextView power;
    }
}
