package com.example.exam1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exam1.Adapter.CategoryAdapter;
import com.example.exam1.R;
import com.example.exam1.config;

import java.io.File;

public class FlowerCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;

        listView=findViewById(R.id.list);

        ActivityCompat.requestPermissions(FlowerCategory.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        CategoryAdapter categoryAdapter =new CategoryAdapter(this);
        listView.setAdapter(categoryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(FlowerCategory.this,FlowerList.class);
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    config.file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Flower");
                    if (config.file.exists())
                    {
                        System.out.println("Folder Available");
                    }
                    else
                    {
                        System.out.println("Folder Not Available");
                        if (config.file.mkdir())
                        {
                            System.out.println("Folder Created");
                        }
                        else
                        {
                            System.out.println("Folder Not Created");
                        }
                    }
                }
                else
                {
                    ActivityCompat.requestPermissions(FlowerCategory.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    Toast.makeText(FlowerCategory.this,"Permission Denied to Read your External Storage",Toast.LENGTH_SHORT).show();
                }

                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}