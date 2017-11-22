package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.ContactAdapter;
import Entities.User;
import manager.UserManager;

public class ContactActivity extends AppCompatActivity {
    Intent intent;
    LinearLayout menuTop, menuBottom, mainLayout,contact;
    ListView myList;
    ArrayAdapter<User> listContactAdapteur;
    Context ctx;
    ImageButton btn_profile,btn_contact,btn_album,btn_map,btn_camera,btn_deconnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.app);
        ctx =this;
        // ContactList test
        ArrayList<User> contactList;

        contactList = UserManager.getAllContact(ctx);
        listContactAdapteur = new ContactAdapter(ctx, R.layout.contact_listview_view, contactList);

        myList = new ListView(ctx);
        myList.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        myList.setAdapter(listContactAdapteur);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = (User) adapterView.getItemAtPosition(i);
                Log.d("mon user prenom", user.getfName());
                Log.d("mon user nom", user.getlName());
                Log.d("mon user id", String.valueOf(user.getId()));

                Intent intent = new Intent(ctx,ProfileActivity.class);
                intent.putExtra("id",user.getId());
                intent.putExtra("prenom",user.getfName());
                intent.putExtra("nom",user.getlName());
                ctx.startActivity(intent);
            }
        });
        contact = (LinearLayout) findViewById(R.id.App_layout);

        menuTop = new LinearLayout(this);
        menuBottom = new LinearLayout(this);
        mainLayout = new LinearLayout(this);

        menuTop = (LinearLayout) getLayoutInflater().inflate(R.layout.menu_top, (LinearLayout) contact.findViewById(R.id.menu_top), true);
        menuBottom = (LinearLayout) getLayoutInflater().inflate(R.layout.menu_bottom, (LinearLayout) contact.findViewById(R.id.menu_bottom), true);

        mainLayout = contact.findViewById(R.id.main_layout);
        mainLayout.addView(myList);


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
