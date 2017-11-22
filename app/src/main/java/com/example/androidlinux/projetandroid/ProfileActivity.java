package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import Entities.Photo;
import Entities.User;
import manager.PhotoManager;
import manager.UserManager;
import utils.MysharedPerfermence;

public class ProfileActivity extends AppCompatActivity implements OnMapReadyCallback {
    Intent intent;
    LinearLayout menuTop, menuBottom, mainLayout, profile;
    GoogleMap googleMap;
    TextView nom,prenom;
    ImageButton btn_profile,btn_contact,btn_album,btn_map,btn_camera,btn_deconnexion;
    MysharedPerfermence mysharedPerfermence;
    User myuser;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ctx=this;
        int idUser = getIntent().getIntExtra("id",-1);
        if (idUser !=-1 ){
            myuser = new User();
            myuser.setId(idUser);
            myuser.setfName(getIntent().getStringExtra("prenom"));
            myuser.setlName(getIntent().getStringExtra("nom"));
        }
        else{
            mysharedPerfermence = new MysharedPerfermence(ctx);
            myuser = mysharedPerfermence.RecoverSharedPermenceUser();
        }

        setContentView(R.layout.app);

        profile = (LinearLayout) findViewById(R.id.App_layout);

        menuTop = new LinearLayout(this);
        menuBottom = new LinearLayout(this);
        mainLayout = new LinearLayout(this);

        getLayoutInflater().inflate(R.layout.menu_top, (LinearLayout) profile.findViewById(R.id.menu_top));
        getLayoutInflater().inflate(R.layout.profile_main, (LinearLayout) profile.findViewById(R.id.main_layout));
        getLayoutInflater().inflate(R.layout.menu_bottom, (LinearLayout) profile.findViewById(R.id.menu_bottom));


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        nom = (TextView) findViewById(R.id.tv_nom_profile);
        prenom = (TextView) findViewById(R.id.tv_prenom_profile);

        btn_profile = (ImageButton) findViewById(R.id.btn_profile);
        btn_contact = (ImageButton) findViewById(R.id.btn_contact);
        btn_album = (ImageButton) findViewById(R.id.btn_album);
        btn_map = (ImageButton) findViewById(R.id.btn_map);
        btn_camera= (ImageButton) findViewById(R.id.btn_camera);
        btn_deconnexion= (ImageButton) findViewById(R.id.btn_deconnection);

        nom.setText(myuser.getlName());
        prenom.setText(myuser.getfName());

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
                new  MysharedPerfermence(ctx).clear();
                intent = new Intent(ctx,ConnexionActivity.class);
                ctx.startActivity(intent);
            }
        });




    }


    @Override
    public void onMapReady(GoogleMap map) {
        ArrayList<Photo> photoUser = PhotoManager.getAllFromUser(ctx,myuser);
        Log.d("test","photo user size ->  "+photoUser.size());
       for (int i=0; i<photoUser.size();i++){
           map.addMarker(new MarkerOptions().position(new LatLng(photoUser.get(i).getLat(), photoUser.get(i).getLon())).title("Marker"));
       }

    }
}
