package com.example.exam1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam1.Activity.FlowerCategory;
import com.example.exam1.R;
import com.example.exam1.config;

public class CategoryAdapter extends BaseAdapter {

    FlowerCategory flowerCategory;

    public CategoryAdapter(FlowerCategory flowerCategory) {
        this.flowerCategory=flowerCategory;
    }

    @Override
    public int getCount() {
        return config.flower_category.length;
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
        convertView= LayoutInflater.from(flowerCategory).inflate(R.layout.extra_category_item,parent,false);

        ImageView imageView=convertView.findViewById(R.id.category_img);
        TextView textView =convertView.findViewById(R.id.category_text);

        imageView.setImageResource(config.flower_image[position]);
        textView.setText(config.flower_category[position]);




        return convertView;
    }
}