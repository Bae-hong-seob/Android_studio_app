package com.bhs.final_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class catalog_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_list);

        Button Korea = (Button) findViewById(R.id.Korea);
        Button Kotakinabalu= (Button) findViewById(R.id.Kotakinabalu);
        Button Singapore = (Button) findViewById(R.id.Singapore);
        Button Japan = (Button) findViewById(R.id.Japan);



        Korea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent korea = new Intent(catalog_list.this, catalog_korea_list.class);
                startActivity(korea);
            }
        });

        Kotakinabalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kotakinabalu = new Intent(catalog_list.this, catalog_kotakinabalu.class);
                startActivity(kotakinabalu);
            }
        });

        Singapore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singapore = new Intent(catalog_list.this, catalog_singapore.class);
                startActivity(singapore);
            }
        });

        Japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent japan = new Intent(catalog_list.this, catalog_japan_list.class);
                startActivity(japan);
            }
        });
    }

    //????????????
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    //???????????? ????????? ?????? -> ?????? ??????
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //???????????? ????????? ???????????? ???????????????
        switch (item.getItemId()) {
            case R.id.photo_option:
                Intent photo = new Intent(catalog_list.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                return true;
            case R.id.map_option:
                Toast.makeText(this, "????????? ??????????????????", Toast.LENGTH_SHORT).show(); // ????????? ?????? ????????? ??? ?????????????????? ???????????? ??????
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
