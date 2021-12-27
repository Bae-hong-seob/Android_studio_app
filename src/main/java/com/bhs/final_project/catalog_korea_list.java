package com.bhs.final_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class catalog_korea_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_korea);

        Button Gangneung = (Button) findViewById(R.id.Gangneung);
        Button Gyeongju = (Button) findViewById(R.id.Gyeonggju);
        Button Busan = (Button) findViewById(R.id.Busan);

        Gangneung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gangneung = new Intent(catalog_korea_list.this, catalog_korea_gangneung.class);
                startActivity(gangneung);
            }
        });

        Gyeongju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gyeongju = new Intent(catalog_korea_list.this, catalog_korea_gyeongju.class);
                startActivity(gyeongju);
            }
        });

        Busan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent busan = new Intent(catalog_korea_list.this, catalog_korea_busan.class);
                startActivity(busan);
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
                Intent photo = new Intent(catalog_korea_list.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(catalog_korea_list.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_korea_list.this, MapsActivity_korea.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
