package com.example.androidlinux.projetandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;

public class MapActivity extends AppCompatActivity {

    LinearLayout menuTop, menuBottom, mainLayout, map;
    GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.app);

        map = (LinearLayout) findViewById(R.id.App_layout);

        menuTop = new LinearLayout(this);
        menuBottom = new LinearLayout(this);
        mainLayout = new LinearLayout(this);

        getLayoutInflater().inflate(R.layout.menu_top, (LinearLayout) map.findViewById(R.id.menu_top));
        getLayoutInflater().inflate(R.layout.menu_bottom, (LinearLayout) map.findViewById(R.id.menu_bottom));
        getLayoutInflater().inflate(R.layout.map_main, (LinearLayout) map.findViewById(R.id.main_layout));

        /*map.addView(menuTop);
        map.addView(mainLayout);
        map.addView(menuBottom);*/
    }
}
