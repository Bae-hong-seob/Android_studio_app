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

public class catalog_kotakinabalu extends AppCompatActivity {

    ListView list;
    String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
            "코타키나발루 - 하늘",
            "코타키나발루 - 만따나니 섬",
            "코타키나발루 - 만따나니 섬",
            "코타키나발루 - Tanjung Aru Beach",
            "코타키나발루 - Tanjung Aru Beach",
            "코타키나발루 - Tanjung Aru Beach",
            "코타키나발루 - Tanjung Aru Beach",
            "코타키나발루 - Tanjung Aru Beach",
            "코타키나발루 - Tanjung Aru Beach",
            "코타키나발루 - Buga Korean Restaurant",
            "코타키나발루 - Mangrove",
            "코타키나발루 - 샴록아이리쉬바",

    } ;
    Integer[] images = {
            R.drawable.kotakinabalu_plane,
            R.drawable.kotakinabalu_mantanani_besar,
            R.drawable.kotakinabalu_mantanani_besar2,
            R.drawable.kotakinabalu_tanjung_aru_beach3,
            R.drawable.kotakinabalu_tanjung_aru_beach1,
            R.drawable.kotakinabalu_tanjung_aru_beach,
            R.drawable.kotakinabalu_tanjung_aru_beach2,
            R.drawable.kotakinabalu_tanjung_aru_beach4,
            R.drawable.kotakinabalu_tanjung_aru_beach5,
            R.drawable.kotakinabalu_buga_korean_restaurant,
            R.drawable.kotakinabalu_mangrove,
            R.drawable.kotakinabalu_kk_waterfront,

    };
    String[] ratings = {
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
            "5.0",
    };
    String[] locations = {
            "코타키나발루 하늘",
            "Kotakinabalu Mantanani Islands",
            "Kotakinabalu Mantanani Islands",
            "15, Jalan Aru, Tanjung Aru, 88100 Kota Kinabalu, Sabah, 말레이시아",
            "15, Jalan Aru, Tanjung Aru, 88100 Kota Kinabalu, Sabah, 말레이시아",
            "15, Jalan Aru, Tanjung Aru, 88100 Kota Kinabalu, Sabah, 말레이시아",
            "15, Jalan Aru, Tanjung Aru, 88100 Kota Kinabalu, Sabah, 말레이시아",
            "15, Jalan Aru, Tanjung Aru, 88100 Kota Kinabalu, Sabah, 말레이시아",
            "15, Jalan Aru, Tanjung Aru, 88100 Kota Kinabalu, Sabah, 말레이시아",
            "Jalan Tun Fuad Stephen, 88000 Kota Kinabalu, Sabah, 말레이시아",
            "말레이시아 89709 Sabah, Bongawan, Unnamed Road, 89709",
            "Lot 14 Waterfront, Pusat Bandar Kota Kinabalu, 88000 Kota Kinabalu, Sabah, 말레이시아",

    };
    String[] dates = {
            "2019-07-09 18시 15분",
            "2019-07-10 11시 37분",
            "2019-07-10 11시 58분",
            "2019-07-11 18시 03분",
            "2019-07-11 18시 28분",
            "2019-07-11 18시 58분",
            "2019-07-11 18시 58분",
            "2019-07-11 18시 13분",
            "2019-07-11 17시 47분",
            "2019-07-12 07시 44분",
            "2019-07-12 18시 26분",
            "2019-07-10 19시 00분",
    };
    String[] links = {
            "https://www.instagram.com/p/B0bLbcOJIj6/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0bLbcOJIj6/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0bLbcOJIj6/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0ngHlZJHay/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0ngHlZJHay/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0ngHlZJHay/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0ngHlZJHay/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0ngHlZJHay/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0ngHlZJHay/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0vBXWZJq5x/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0vBXWZJq5x/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/B0bLbcOJIj6/?utm_source=ig_web_copy_link",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_commonuse);

        //어댑터 뷰(리스트 뷰)를 커스텀하여 사용(CustomList)
        catalog_kotakinabalu.CustomList adapter = new
                catalog_kotakinabalu.CustomList(catalog_kotakinabalu.this);
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
                Intent photo = new Intent(catalog_kotakinabalu.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(catalog_kotakinabalu.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_kotakinabalu.this, MapsActivity_kotakinablau.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}