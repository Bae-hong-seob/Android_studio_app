package com.bhs.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.system.Os;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class catalog_japan_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_japan);

        Button Osaka = (Button) findViewById(R.id.Osaka);
        Button Tokyo = (Button) findViewById(R.id.Tokyo);
        Button Fukuoka = (Button) findViewById(R.id.Fukuoka);

        Osaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent osaka = new Intent(catalog_japan_list.this, catalog_japan_osaka.class);
                startActivity(osaka);
            }
        });
        Tokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tokyo = new Intent(catalog_japan_list.this, catalog_japan_osaka.class);
                startActivity(tokyo);
            }
        });
        Fukuoka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fukuoka = new Intent(catalog_japan_list.this, catalog_japan_osaka.class);
                startActivity(fukuoka);
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
                Intent photo = new Intent(catalog_japan_list.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_japan_list.this, MapsActivity_japan.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
