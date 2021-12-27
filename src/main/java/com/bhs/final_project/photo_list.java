package com.bhs.final_project;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

public class photo_list extends AppCompatActivity {

    ListView list;
    String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
            // adapter list view 에 전달할 정보들
            "강릉 - 곳 카페",
            "강릉 - 바다(세인트존스호텔)",
            "경주 - 선덕여왕 공원",
            "경주 - 샌드그레이스 피크닉",
            "경주 - 월정교",
            "경주 - 동궁과 월지",
            "경주 - 골목길",
            "부산 - 광안리",
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
            "싱가포르 - Tanjong Beach Club",
            "싱가포르 - Tanjong Beach",
            "싱가포르 - Tanjong Beach",
            "싱가포르 - Tanjong Beach Club",
            "싱가포르 - Marina Bay Sands Hotels",
            "싱가포르 - Marina Bay Sands Hotels",
            "싱가포르 - Marina Bay Sands Hotels",
            "싱가포르 - Marina Bay Sands Hotels",
            "싱가포르 - Universal Studios",
            "싱가포르 - Universal Studios",
            "싱가포르 - Universal Studios",
            "싱가포르 - Universal Studios",
            "싱가포르 - Marina Bay Sands",
            "싱가포르 - Gardens By the Bay",
            "싱가포르 - Adventure Cove Waterpark",
            "싱가포르 - Clarke Quay",
    } ;
    Integer[] images = {
            R.drawable.gangneung_place_cafe,
            R.drawable.gangneung_saint_hotel_sea,
            R.drawable.gyeongju_bomun_lake,
            R.drawable.gyeongju_picnic,
            R.drawable.gyeongju_woljeonggyo_bridge,
            R.drawable.gyeongju_donggung_and_wolji,
            R.drawable.gyeongju,
            R.drawable.busan_gwanganri,
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
            R.drawable.singapore_tanjongbeach,
            R.drawable.singapore_tanjongbeach2,
            R.drawable.singapore_tanjongbeach3,
            R.drawable.singapore_tanjongbeach4,
            R.drawable.singapore_marinabaysands_hotel,
            R.drawable.singapore_marinabaysands_hotel2,
            R.drawable.singapore_marinabaysands_hotel3,
            R.drawable.singapore_marinabaysands_hotel4,
            R.drawable.singapore_universal_studio,
            R.drawable.singapore_universal_studio2,
            R.drawable.singapore_universal_studio3,
            R.drawable.singapore_universal_studio4,
            R.drawable.singapore_marinabaysands,
            R.drawable.singapore_gardensbythebay,
            R.drawable.singapore_adventure_cove_waterpark,
            R.drawable.singapore_clarke_quay,
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
            "강원 강릉시 사천면 진리해변길 143",
            "강원 강릉시 창해로 307",
            "경북 경주시 북군동 114-11",
            "경북 경주시 황남동 241-9",
            "경북 경주시 교동",
            "경북 경주시 원화로 102 안압지",
            "경북 경주시 교동 근처",
            "부산광역시 광안2동",
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
            "120 Tanjong Beach Walk, 싱가포르 098942",
            "120 Tanjong Beach Walk, 싱가포르 098942",
            "120 Tanjong Beach Walk, 싱가포르 098942",
            "120 Tanjong Beach Walk, 싱가포르 098942",
            "10 Bayfront Ave, Singapore 018956",
            "10 Bayfront Ave, Singapore 018956",
            "10 Bayfront Ave, Singapore 018956",
            "10 Bayfront Ave, Singapore 018956",
            "8 Sentosa Gateway, 싱가포르 098269",
            "8 Sentosa Gateway, 싱가포르 098269",
            "8 Sentosa Gateway, 싱가포르 098269",
            "8 Sentosa Gateway, 싱가포르 098269",
            "10 Bayfront Ave, Singapore 018956",
            "211 Marina Way, Singapore 018977",
            "8 Sentosa Gateway, 싱가포르 098269",
            "3 River Valley Rd, 싱가포르 179024",
    };
    String[] dates = {
            "2020-11-11 17시 08분",
            "2020-11-10 22시 37분", // 강릉
            "2019-10-28 17시 37분",
            "2019-07-26 12시 32분",
            "2019-07-26 19시 07분",
            "2019-07-25 20시 34분",
            "2019-07-26 19시 57분", // 경주
            "2017-02-02 19시 55분", // 부산
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
            "2019-07-10 19시 00분", // 코타키나발루
            "2019-02-13 09시 40분",
            "2019-02-13 19시 07분",
            "2019-02-13 19시 08분",
            "2019-02-13 20시 48분",
            "2019-02-15 13시 05분",
            "2020-02-15 20시 41분",
            "2020-02-15 20시 25분",
            "2020-02-14 14시 31분",
            "2020-02-15 20시 25분",
            "2020-02-14 11시 21분",
            "2020-02-14 11시 22분",
            "2020-02-14 14시 15분",
            "2020-02-14 17시 45분",
            "2020-02-15 20시 59분",
            "2020-02-13 14시 08분",
            "2020-02-14 23시 35분",
    };
    String[] links = {
            "https://www.instagram.com/p/CHg7o6XJT5t/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqLEAbP67O/?utm_source=ig_web_copy_link", // 강릉
            "https://www.instagram.com/p/CWqMVgwP6rg/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/Bx6_jhrpxAT/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqMgV0vEnE/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqMcj2Pqpf/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqMkFsvsv9/?utm_source=ig_web_copy_link", // 경주
            "https://www.instagram.com/p/CWqNStYP9im/?utm_source=ig_web_copy_link", // 부산
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
            "https://www.instagram.com/p/B0bLbcOJIj6/?utm_source=ig_web_copy_link", // 코타키나발루
            "https://www.instagram.com/p/BuBKWZUhgYp/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/BuBKWZUhgYp/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/BuBKWZUhgYp/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/BuBKWZUhgYp/?utm_source=ig_web_copy_link", // 탄중아루
            "https://www.instagram.com/p/CWqRFcuPU3O/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqRFcuPU3O/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqRFcuPU3O/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/CWqRFcuPU3O/?utm_source=ig_web_copy_link", // 마리나베이 호텔
            "https://www.instagram.com/p/BuGcjhAhMEN/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/BuGcjhAhMEN/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/BuGcjhAhMEN/?utm_source=ig_web_copy_link",
            "https://www.instagram.com/p/BuGcjhAhMEN/?utm_source=ig_web_copy_link", // 유니버셜
            "https://www.instagram.com/p/CWqRXNmPpMM/?utm_source=ig_web_copy_link", // 가든더베이(다리)
            "https://www.instagram.com/p/CWqRXNmPpMM/?utm_source=ig_web_copy_link", // 가든더베이
            "https://www.instagram.com/p/CWqR3ZIPm1A/?utm_source=ig_web_copy_link", // 워터파크
            "https://www.instagram.com/p/CWqR9q1vfkk/?utm_source=ig_web_copy_link", // 클라크퀘이
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        //adapter view(list view) 를 사용(CustomList)
        CustomList adapter = new
                CustomList(photo_list.this);
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

    //Custom View 이름 CustomList
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
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(photo_list.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Toast.makeText(this, "목록으로 보기에서 지역을 선택해주세요.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
