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
import com.bhs.final_project.databinding.ActivityMapsKotakinablauBinding;

public class MapsActivity_kotakinablau extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsKotakinablauBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsKotakinablauBinding.inflate(getLayoutInflater());
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
                5.923039740678257, // 하늘
                6.718626842132716,
                6.718626842132716,
                5.956761244980547,
                5.956761244980547,
                5.9567388121647395,
                5.9560164750056215,
                5.956761244980547,
                5.956761244980547,
                5.978400336643807,
                5.5247658599750915,
                5.979240740452856,
        };

        double longitude[] = {
                116.05086854022824,
                116.33316150422868,
                116.33316150422868,
                116.04022497849137,
                116.04022497849137,
                116.04096928027343,
                116.04035579516822,
                116.04022497849137,
                116.04022497849137,
                116.06966748982833,
                115.79241972660853,
                116.06982667209017,
        };
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

        // Add a marker in Sydney and move the camera

        for (int i = 0; i < 12; i++){
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