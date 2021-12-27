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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class catalog_singapore extends AppCompatActivity {

    ListView list;
    String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
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
    };
    String[] locations = {
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
        setContentView(R.layout.photo_list_commonuse);

        //어댑터 뷰(리스트 뷰)를 커스텀하여 사용(CustomList)
        catalog_singapore.CustomList adapter = new
                catalog_singapore.CustomList(catalog_singapore.this);
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
                Intent photo = new Intent(catalog_singapore.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(catalog_singapore.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_singapore.this, MapsActivity_singapore.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

