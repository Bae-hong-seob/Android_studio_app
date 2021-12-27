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

public class catalog_korea_gyeongju extends AppCompatActivity {

    ListView list;
    String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
            "경주 - 선덕여왕 공원",
            "경주 - 샌드그레이스 피크닉",
            "경주 - 월정교",
            "경주 - 동궁과 월지",
            "경주 - 골목길"
    } ;
    Integer[] images = {
            R.drawable.gyeongju_bomun_lake,
            R.drawable.gyeongju_picnic,
            R.drawable.gyeongju_woljeonggyo_bridge,
            R.drawable.gyeongju_donggung_and_wolji,
            R.drawable.gyeongju,
    };
    String[] ratings = {
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0"
    };
    String[] locations = {
            "경북 경주시 북군동 114-11",
            "경북 경주시 황남동 241-9",
            "경북 경주시 교동",
            "경북 경주시 원화로 102 안압지",
            "경북 경주시 교동 근처",
    };
    String[] dates = {
            "2019-10-28 17시 37분",
            "2019-07-26 12시 32분",
            "2019-07-26 19시 07분",
            "2019-07-25 20시 34분",
            "2019-07-26 19시 57분",
    };

    String[] links = {
            "https://www.instagram.com/p/CWqMVgwP6rg/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/Bx6_jhrpxAT/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqMgV0vEnE/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqMcj2Pqpf/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqMkFsvsv9/?utm_source=ig_web_copy_link",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_commonuse);

        //어댑터 뷰(리스트 뷰)를 커스텀하여 사용(CustomList)
        catalog_korea_gyeongju.CustomList adapter = new
                catalog_korea_gyeongju.CustomList(catalog_korea_gyeongju.this);
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
                Intent photo = new Intent(catalog_korea_gyeongju.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(catalog_korea_gyeongju.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_korea_gyeongju.this, MapsActivity_korea.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
