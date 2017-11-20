package com.example.androidlinux.projetandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class ProfileActivity extends AppCompatActivity implements OnMapReadyCallback {
    LinearLayout menuTop, menuBottom, mainLayout, profile;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.app);

        profile = (LinearLayout) findViewById(R.id.App_layout);

        menuTop = new LinearLayout(this);
        menuBottom = new LinearLayout(this);
        mainLayout = new LinearLayout(this);

        menuTop = (LinearLayout) getLayoutInflater().inflate(R.layout.menu_top, (LinearLayout) profile.findViewById(R.id.menuTop), false);
        menuBottom = (LinearLayout) getLayoutInflater().inflate(R.layout.menu_bottom, (LinearLayout) profile.findViewById(R.id.menuBottom), false);

        mainLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.profile_main, (LinearLayout) profile.findViewById(R.id.main_layout), false);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        profile.addView(menuTop);
        profile.addView(mainLayout);
        profile.addView(menuBottom);



    }


    public void onMapReady(GoogleMap map) {

    }
}
