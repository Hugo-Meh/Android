package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import Entities.User;
import manager.UserManager;
import utils.UseaGeocoder;

public class Bravo extends AppCompatActivity {
    Context ctx;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bravo);
        ctx = this;
        tv = (TextView) findViewById(R.id.textTest);
        String infoUserDB;
        User user;
        user = UserManager.verifyUser(ctx,"hugo", "abc123");
        tv.setText(user.getLogin()+" "+user.getPwd());

        UseaGeocoder aGeocoderuser = new UseaGeocoder(ctx);
        Log.d("Pays",aGeocoderuser.getCountryName(50,25));
        aGeocoderuser.getCountryName(50,25);
    }
}
