package com.bhs.final_project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class catalog_korea_gangneung extends AppCompatActivity {

    ListView list;
    String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
            "강릉 - 곳 카페",
            "강릉 - 바다(세인트존스호텔)"
    } ;
    Integer[] images = {
            R.drawable.gangneung_place_cafe,
            R.drawable.gangneung_saint_hotel_sea
    };
    String[] ratings = {
            "5.0",
            "5.0"
    };
    String[] locations = {
            "강원 강릉시 사천면 진리해변길 143",
            "강원 강릉시 창해로 307",
    };
    String[] dates = {
            "2020-11-11 17시 08분",
            "2020-11-10 22시 37분",
    };

    String[] links = {
            "https://www.instagram.com/p/CHg7o6XJT5t/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqLEAbP67O/?utm_source=ig_web_copy_link",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_commonuse);

        //어댑터 뷰(리스트 뷰)를 커스텀하여 사용(CustomList)
        catalog_korea_gangneung.CustomList adapter = new
                catalog_korea_gangneung.CustomList(catalog_korea_gangneung.this);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(links[position]));
                startActivity(intent);
            }
        });
    }

    //커스텀뷰
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context ) {
            super(context, R.layout.listitem, titles);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView rating = (TextView) rowView.findViewById(R.id.rating);
            TextView location = (TextView) rowView.findViewById(R.id.location);
            TextView date = (TextView) rowView.findViewById(R.id.date);

            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText(ratings[position]);
            location.setText(locations[position]);
            date.setText(dates[position]);
            return rowView;
        }
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
                Intent photo = new Intent(catalog_korea_gangneung.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(catalog_korea_gangneung.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_korea_gangneung.this, MapsActivity_korea.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
