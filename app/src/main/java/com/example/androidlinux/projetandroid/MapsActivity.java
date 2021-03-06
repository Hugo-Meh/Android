package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;

import Entities.MyItem;
import Entities.Photo;
import Entities.PhotoMarker;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public Context ctx;
    private GoogleMap mMap;
    private ArrayList<Photo> MyPhotos;
    private ClusterManager<MyItem> CManagerMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ctx = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        MyPhotos = new ArrayList<Photo>();
        ArrayList<MyItem> clusterMyItemList = new ArrayList<MyItem>();





        CManagerMap = new ClusterManager<MyItem>(ctx,mMap);
        mMap.setOnCameraIdleListener(CManagerMap);
        for (int i=0;i<clusterMyItemList.size();i++){
            CManagerMap.addItem(clusterMyItemList.get(i));
        }


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
