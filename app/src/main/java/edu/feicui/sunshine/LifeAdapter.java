package edu.feicui.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.feicui.sunshine.bean.LifeBean;

/**
 * Created by Administrator on 2016/5/27.
 */
public class LifeAdapter extends BaseAdapter{
    LayoutInflater mInflater;
    List<LifeBean> data;

    public LifeAdapter(Context context, List<LifeBean> data) {
        mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        if(data!=null){
        return data.size();
        }
        return 0;
    }

    @Override
    public LifeBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_life_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.exp = (TextView) convertView.findViewById(R.id.tv_exp);
            holder.miute = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(getItem(position).title);
        holder.exp.setText(getItem(position).exp);
        holder.miute.setText(getItem(position).content);
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView exp;
        TextView miute;
    }
}
