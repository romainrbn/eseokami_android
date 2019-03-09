package com.eseokami.romainrabouan.eseokamijava;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;


public class HotlineFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    GoogleMap mGoogleMap;
    MapView mMapView;

 //  Restaurant[] restaurants = new Restaurant[26];

    double lats[] = {47.477481, 47.474004, 47.471977, 47.469004, 47.468175, 47.471387, 47.475239, 47.476849,
            47.472398, 47.470011, 47.474063, 47.474275, 47.473104, 47.467546, 47.466914, 47.466793, 47.466149,
            47.473704, 47.472054, 47.474637, 47.4758, 47.467431, 47.470998, 47.467763, 47.474184, 47.470176};

    double longs[] = {-0.558136, -0.559594, -0.556270, -0.550062, -0.550454, -0.554010, -0.549160, -0.550371,
            -0.551090, -0.548717, -0.553576, -0.553573, -0.549077, -0.558897, -0.556845, -0.548401, -0.547023,
            -0.571082, -0.556430, -0.560500, -0.551149, -0.549907, -0.550602, -0.550561, -0.554118, -0.548473};

    String titles[] = {"O'classic", "Le régal de la Doutre", "Chicken Wrap", "La Mie Câline", "Restaurant Vf", "Subway Fleur d'eau",
            "Le Tam'", "Subway St Serge", "Le lézard vert", "McDonald's Boulevard Foch", "Pizza Tempo", "Speed Burger", "Le Punjab",
            "Domino's Pizza", "L'oriflamme", "Vite&Frais", "Chez Minh", "La Boîte à Pizzas", "Orient'Halles", "Le Quai Bab d'Aladin",
            "Point Chicken", "McDoner", "Ylios Arhadia", "Ashiq Muhammad", "O'Tacos Angers", "Takos King"};
    Restaurant restaurants[] = {
            new Restaurant("O'classic", "O_classic"),
            new Restaurant("Le régal de la Doutre", "regal_doutre"),
            new Restaurant("Chicken Wrap", "chicken_wrap"),
            new Restaurant("La Mie Câline", "mie_caline"),
            new Restaurant("Restaurant Vf", "restaurant_vf"),
            new Restaurant("Subway Fleur d'eau", "subway_fleur"),
            new Restaurant("Le Tam'", "tam"),
            new Restaurant("Subway St-Serge", "subway_saint_serge"),
            new Restaurant("Le lézard vert", "lezard_vert"),
            new Restaurant("McDonald's Boulevard Foch", "mcdo_foch"),
            new Restaurant("Pizza Tempo", "pizza_tempo"),
            new Restaurant("Speed Burger", "speed_burger"),
            new Restaurant("Le Punjab", "punjab"),
            new Restaurant("Domino's Pizza", "dominos"),
            new Restaurant("L'oriflamme", "oriflamme"),
            new Restaurant("Vite & Frais", "vite_frais"),
            new Restaurant("Chez Minh", "minh"),
            new Restaurant("La Boîte à Pizzas", "boite_pizzas"),
            new Restaurant("Orient'Halles", "orient_halles"),
            new Restaurant("Le Quai Bab d'Aladin", "quai_bab"),
            new Restaurant("Point Chicken", "point_chicken"),
            new Restaurant("McDoner", "mcdoner"),
            new Restaurant("Ylios Arhadia", "ylios"),
            new Restaurant("Ashiq Muhammad", "ashiq"),
            new Restaurant("O'Tacos Angers", "otacos"),
            new Restaurant("Takos King", "takos_king"),

    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotline, container, false);
        getActivity().setTitle("Les offrandes de Kitsune");

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }


        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        int color = Color.RED;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);




        for (int i = 0; i < restaurants.length; i++) {
            googleMap.addMarker(new MarkerOptions().position(new LatLng(lats[i], longs[i])).title(restaurants[i].nameRest));
        }


        CameraPosition region = CameraPosition.builder().target(new LatLng(47.4698, -0.5593)).zoom(13).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(region));

        Circle circle = googleMap.addCircle(new CircleOptions()
                .center(new LatLng(47.481539, -0.554895))
                .radius(1720)
                .strokeColor(Color.RED)
                .fillColor(ColorUtils.setAlphaComponent(Color.RED, 26))
        );

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                HotlineRestaurantBottomSheet hotlineRestaurantBottomSheet = new HotlineRestaurantBottomSheet();
                Log.d("ID_MARKER", marker.getId());
                hotlineRestaurantBottomSheet.restaurantName = marker.getTitle();
                hotlineRestaurantBottomSheet.restaurantId = restaurants[Integer.parseInt(marker.getId().substring(1))].idRest;
                Log.d("SUCCESSSS", hotlineRestaurantBottomSheet.restaurantId);
                hotlineRestaurantBottomSheet.show(getFragmentManager(), "hotlineBottomSheet");
            }
        });
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        //
    }
}
