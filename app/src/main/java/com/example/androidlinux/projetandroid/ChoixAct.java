package com.example.androidlinux.projetandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoixAct extends AppCompatActivity {
    Button btn_lunch_camera,btn_display_album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        btn_lunch_camera= (Button) findViewById(R.id.Btn_new_lunch_camera);
        btn_display_album= (Button) findViewById(R.id.Btn_new_camera_act_go_to_album);
        btn_lunch_camera.setOnClickListener(new View.OnClickListener() {
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
        });

    }
}
