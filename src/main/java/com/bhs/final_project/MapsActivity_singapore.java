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
import com.bhs.final_project.databinding.ActivityMapsSingaporeBinding;

public class MapsActivity_singapore extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsSingaporeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsSingaporeBinding.inflate(getLayoutInflater());
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
                1.2428151077811718,
                1.2419153047488176,
                1.2422728053997512,
                1.2433460330816852,
                1.2840437725928924,
                1.284043772592892,
                1.28404377259289,
                1.2840437725928,
                1.2542797364087586,
                1.254279736408758,
                1.25427973640875,
                1.2542797364087,
                1.2825257375062116,
                1.2818178116346866, // 가든스 바이 더 베이
                1.2589939977654971,
                1.2908061952242809,
        };

        double longitude[] = {
                103.82839214873364,
                103.82931889853461,
                103.82825559294983,
                103.82814179646331,
                103.8607308494787,
                103.860730849478,
                103.86073084947,
                103.8607308494,
                103.82376191479551,
                103.8237619147955,
                103.823761914795,
                103.82376191479,
                103.86163457400647,
                103.86373742579167,
                103.81868415544992,
                103.84689262236843,
        };
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

        // Add a marker in Sydney and move the camera

        for (int i = 0; i < 16; i++){
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