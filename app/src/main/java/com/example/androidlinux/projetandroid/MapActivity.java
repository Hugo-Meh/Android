package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;

public class MapActivity extends AppCompatActivity {
    Intent intent;
    ImageButton btn_profile,btn_contact,btn_album,btn_map,btn_camera,btn_deconnexion;
    LinearLayout menuTop, menuBottom, mainLayout, map;
    Context ctx;
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

        btn_profile = (ImageButton) findViewById(R.id.btn_profile);
        btn_contact = (ImageButton) findViewById(R.id.btn_contact);
        btn_album = (ImageButton) findViewById(R.id.btn_album);
        btn_map = (ImageButton) findViewById(R.id.btn_map);
        btn_camera= (ImageButton) findViewById(R.id.btn_camera);
        btn_deconnexion= (ImageButton) findViewById(R.id.btn_deconnection);

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ctx,ProfileActivity.class);
                ctx.startActivity(intent);
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ctx,ContactActivity.class);
                ctx.startActivity(intent);
            }
        });

        btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ctx,AlbumActivity.class);
                ctx.startActivity(intent);
            }
        });

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ctx,MapActivity.class);
                ctx.startActivity(intent);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ctx,NewCameraActivity.class);
                ctx.startActivity(intent);
            }
        });

        btn_deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ctx,ConnexionActivity.class);
                ctx.startActivity(intent);
            }
        });



    }


}
