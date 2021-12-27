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
import com.bhs.final_project.databinding.ActivityMapsJapanBinding;

public class MapsActivity_japan extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsJapanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsJapanBinding.inflate(getLayoutInflater());
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
                34.669607866045965,
                34.66940380666637,
                34.74749686105974,
                34.66554311035488,
                34.66430481570017,
                34.66493970637315,
                34.66698183924655,
                34.666598101208955,
        };

        double longitude[] = {
                135.50101318465738,
                135.5030175403956,
                135.61134488457503,
                135.43234921283207,
                135.43223438356281,
                135.4311498849088,
                135.43318840376483,
                135.4352177744642,
        };
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

        // Add a marker in Sydney and move the camera

        for (int i = 0; i < 8; i++){
            LatLng latLng = new LatLng(latitude[i], longitude[i]);

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position((latLng)).title(titles[i]);

            BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(images[i]);
            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

            mMap.addMarker(markerOptions);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude[0],longitude[0])));

    }
}