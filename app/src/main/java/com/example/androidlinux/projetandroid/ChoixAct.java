package com.example.androidlinux.projetandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

import Views.MenuTop;

public class ChoixAct extends AppCompatActivity {
    Button btn_profil,btn_display_album,btn_display_album2;
    MenuTop menuTop;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;

        menuTop = new MenuTop(ctx);

        //btn_lunch_camera= new Button(ctx);
        //btn_lunch_camera.setText("Profile");
        btn_display_album= new Button(ctx);
        btn_display_album.setText("Contact");
        btn_display_album2= new Button(ctx);
        btn_display_album2.setText("album");



       // menuTop.addView(btn_lunch_camera);
        menuTop.addView(btn_display_album);
        menuTop.addView(btn_display_album2);

        setContentView(menuTop);


        /*btn_lunch_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent= new Intent(ChoixAct.this,NewCameraActivity.class);
                startActivity(intent);
            }
        });
        btn_display_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ChoixAct.this,ShowImage.class);
                startActivity(intent);
            }
        });*/



    }
}
