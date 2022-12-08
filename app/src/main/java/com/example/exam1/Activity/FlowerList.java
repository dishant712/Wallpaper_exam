package com.example.exam1.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.exam1.Adapter.ListAdapter;
import com.example.exam1.R;
import com.example.exam1.config;

public class FlowerList extends AppCompatActivity {

    GridView gridView;
    ActionBar actionBar;
    int pos;
    int[] img;
    String[] name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_list);


//        TextView text = findViewById(R.id.text);

        actionBar=getSupportActionBar();
        actionBar.setTitle(config.flower_category[pos]);

        gridView=findViewById(R.id.grid);

        pos = getIntent().getIntExtra("pos",0);

        if (pos == 0){
            name = config.red_rose_text;
            img = config.red_rose_img;
        }
        if (pos == 1)
        {
            name = config.white_rose_text;
            img = config.white_rose_img;
        }
        if (pos == 2)
        {
            name = config.pink_rose_text;
            img = config.pink_rose_img;
        }
        if (pos == 3)
        {
            name = config.blue_rose_text;
            img = config.blue_rose_img;
        }

        ListAdapter  listAdapter = new ListAdapter(this,name,img);
        gridView.setAdapter(listAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent =  new Intent(FlowerList.this,view.class);
                intent.putExtra("pos",i);
                intent.putExtra("name",name);
                intent.putExtra("img",img);
                startActivity(intent);
            }
        });

    }
}