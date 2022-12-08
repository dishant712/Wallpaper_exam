package com.example.exam1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam1.Activity.FlowerCategory;
import com.example.exam1.Activity.FlowerList;
import com.example.exam1.R;
import com.example.exam1.config;

public class ListAdapter extends BaseAdapter {

    FlowerList flowerList;
    String[] name;
    int[] img;


    public ListAdapter(FlowerList flowerList, String[] name, int[] img) {

        this.flowerList=flowerList;
        this.img=img;
        this.name=name;
    }

    @Override
    public int getCount() {
        return name.length;
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
        convertView= LayoutInflater.from(flowerList).inflate(R.layout.extra_flowerlist_item,parent,false);

        ImageView imageView=convertView.findViewById(R.id.extraflower_img);
        TextView textView =convertView.findViewById(R.id.extraflower_text);

        imageView.setImageResource(img[position]);
        textView.setText(name[position]);



        return convertView;
    }
}