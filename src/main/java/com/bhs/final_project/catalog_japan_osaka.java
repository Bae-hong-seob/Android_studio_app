package com.bhs.final_project;

import android.app.Activity;
import android.content.Intent;
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

public class catalog_japan_osaka extends AppCompatActivity {

    ListView list;
    String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
            "오사카 - 도톤보리",
            "오사카 - 도톤보리 이치란라멘",
            "오사카 - 가야시마역",
            "오사카 - Universal Studios Japan",
            "오사카 - Universal Studios Japan",
            "오사카 - Universal Studios Japan",
            "오사카 - Universal Studios Japan",
            "오사카 - Universal Studios Japan souvenir",
    } ;
    Integer[] images = {
            R.drawable.japan_dotonbori,
            R.drawable.japan_dotonbori_ramen,
            R.drawable.japan_kayashimahonmachi,
            R.drawable.japan_universal_studios_japan,
            R.drawable.japan_universal_studios_japan2,
            R.drawable.japan_universal_studios_japan3,
            R.drawable.japan_universal_studios_japan4,
            R.drawable.japan_universal_studios_japan5,
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
    };
    String[] locations = {
            "1 Chome Dotonbori, Chuo Ward, Osaka, 542-0071 일본",
            "7-18 Souemoncho, Chuo Ward, Osaka, 542-0084 일본",
            "19 Kayashimahonmachi, Neyagawa, Osaka 572-0827 일본",
            "2 Chome-1-33 Sakurajima, Konohana Ward, Osaka, 554-0031 일본",
            "2 Chome-1-33 Sakurajima, Konohana Ward, Osaka, 554-0031 일본",
            "2 Chome-1-33 Sakurajima, Konohana Ward, Osaka, 554-0031 일본",
            "2 Chome-1-33 Sakurajima, Konohana Ward, Osaka, 554-0031 일본",
            "2 Chome-1-33 Sakurajima, Konohana Ward, Osaka, 554-0031 일본",
    };
    String[] dates = {
            "2017-01-25 20시 37분",
            "2017-01-25 18시 45분",
            "2017-01-28 15시 10분",
            "2017-01-26 10시 20분",
            "2017-01-26 11시 18분",
            "2017-01-26 11시 20분",
            "2017-01-26 14시 25분",
            "2017-01-26 20시 34분",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_commonuse);

        //어댑터 뷰(리스트 뷰)를 커스텀하여 사용(CustomList)
        catalog_japan_osaka.CustomList adapter = new
                catalog_japan_osaka.CustomList(catalog_japan_osaka.this);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), titles[+position], Toast.LENGTH_SHORT).show();
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
                Intent photo = new Intent(catalog_japan_osaka.this, photo_list.class);
                startActivity(photo);
                return true;
            case R.id.catalog:
                Intent catalog = new Intent(catalog_japan_osaka.this, catalog_list.class);
                startActivity(catalog);
                return true;
            case R.id.map_option:
                Intent intent = new Intent(catalog_japan_osaka.this, MapsActivity_japan.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}