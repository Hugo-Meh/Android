package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Entities.User;
import manager.UserManager;

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
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(ctx);
        String token=sharedPreferences.getString("token","");
        if(!token.equals("")){
            String fName=sharedPreferences.getString("fName","");
            String lName=sharedPreferences.getString("lName","");
            int id=sharedPreferences.getInt("id",0);
            tv.setText(fName+" "+lName);
        }
//        user = UserManager.verifyUser(ctx,"hugo", "abc123");
//        tv.setText(user.getLogin()+" "+user.getPwd());
    }
}
