package com.liu.myapplication.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.liu.myapplication.Bean;
import com.liu.myapplication.MainActivity;
import com.liu.myapplication.R;

import java.util.List;

/**
    左侧Adapter
 */
public class LeftAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Bean> list;



    public LeftAdapter(Context mContext, List<Bean> list) {
        this.list = list;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            //加载
            convertView = inflater.inflate(R.layout.lv_item_left, parent, false);
            //绑定
            holder.lv_left_item_text = (TextView) convertView.findViewById(R.id.lv_left_item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //设置数据
        holder.lv_left_item_text.setText(list.get(position).getName());
        //根据标志位，设置背景颜色
        if (list.get(position).isIsBoolean()) {
            holder.lv_left_item_text.setBackgroundColor(Color.rgb(255, 255, 255));
        } else {
            holder.lv_left_item_text.setBackgroundColor(Color.TRANSPARENT);
        }
        return convertView;
    }

    class ViewHolder {
        private TextView lv_left_item_text;
    }
}