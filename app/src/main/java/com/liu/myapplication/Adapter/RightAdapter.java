package com.liu.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liu.myapplication.Bean;
import com.liu.myapplication.R;
import java.util.List;


public class RightAdapter extends CustomizeLVBaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Bean> list;


    public RightAdapter(Context mContext, List<Bean> list) {
        this.mContext = mContext;
        this.list = list;
        //系统服务
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int section, int position) {
        return list.get(section).getList().get(position);
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return list.size();
    }

    @Override
    public int getCountForSection(int section) {
        return list.get(section).getList().size();
    }

    @Override
    public View getItemView(final int section, final int position, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null) {
            holder = new ChildViewHolder();
            //加载
            convertView = inflater.inflate(R.layout.lv_customize_item_right, parent, false);
            //绑定
            holder.lv_customize_item_image = (ImageView) convertView.findViewById(R.id.lv_customize_item_image);
            holder.lv_customize_item_text = (TextView) convertView.findViewById(R.id.lv_customize_item_text);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        //设置内容
        holder.lv_customize_item_text.setText(list.get(section).getList().get(position).getName());
        //点击事件
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,list.get(section).getList().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        HeaderViewHolder holder = null;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            //加载
            convertView = inflater.inflate(R.layout.lv_customize_item_header, parent, false);
            //绑定
            holder.lv_customize_item_header_text = (TextView) convertView.findViewById(R.id.lv_customize_item_header_text);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //不可点击
        convertView.setClickable(false);
        //设置标题
        holder.lv_customize_item_header_text.setText(list.get(section).getName());
        return convertView;
    }

    class ChildViewHolder {
        //Item图片
        private ImageView lv_customize_item_image;
        //Item内容
        private TextView lv_customize_item_text;
    }

    class HeaderViewHolder {
        //标题
        private TextView lv_customize_item_header_text;
    }
}

