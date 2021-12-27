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

    //옵션메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    //옵션메뉴 이벤트 처리 -> 화면 전환
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //화면전환 인텐트 객체사용 구현해야됨
        switch (item.getItemId()) {
            case R.id.photo_option:
                Intent photo = new Intent(catalog_list.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                return true;
            case R.id.map_option:
                Toast.makeText(this, "나라을 선택해주세요", Toast.LENGTH_SHORT).show(); // 범위가 너무 크므로 더 진행해달라는 사용방법 안내
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
