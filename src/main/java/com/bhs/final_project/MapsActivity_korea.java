package com.bhs.final_project;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.bhs.final_project.databinding.ActivityMapsBinding;

public class MapsActivity_korea extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double latitude[] = {
                37.84314804165307, // 곳 카페
                37.79128094883453, // 세인트 존스 호텔
                35.85272941214221, // 선덕여왕 공원
                35.83652672686126, // 샌드그레이스
                35.829358052852314,
                35.83490014741939,
                35.837718807858614,
                35.15316975139728,
        };

        double longitude[] = {
                128.87298606309054,// 곳 카페
                128.92111161338553, // 세인트 존스 호텔
                129.27035125596163, // 선덕여왕 공원
                129.21073636945314,
                129.21803546945293,
                129.2265923847975, // 동궁과 월지
                129.2097133225887,
                129.11866676918643,
        };
        String[] titles = { //titles, images, ratings, locations 변수 갯수들이 동일하지 않으면 스크롤내릴때 에러발생
                "강릉 - 곳 카페",
                "강릉 - 바다(세인트존스호텔)",
                "경주 - 선덕여왕 공원",
                "경주 - 샌드그레이스 피크닉",
                "경주 - 월정교",
                "경주 - 동궁과 월지",
                "경주 - 골목길",
                "부산 - 광안리",
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
        };


        for (int i = 0; i < 8; i++){ // 다중마커 생성하기 위해 반복문 사용
            LatLng latLng = new LatLng(latitude[i], longitude[i]);

            MarkerOptions markerOptions = new MarkerOptions(); //마커생성
            markerOptions.position((latLng)).title(titles[i]); //마커를 해당 위도, 경도에 위치

            BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(images[i]); //비트맵으로 사진 받아오기
            Bitmap b = bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker)); //받아온 사진을 마커의 이미지로 변경

            mMap.addMarker(markerOptions); //마커를 지도에 추가
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude[0],longitude[0])));

    }
}