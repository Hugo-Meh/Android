package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.ContactAdapter;
import Entities.User;

public class ContactActivity extends AppCompatActivity {
    LinearLayout menuTop, menuBottom, mainLayout,contact;
    ListView myList;
    ArrayAdapter<User> listContactAdapteur;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.app);
        ctx =this;
        // ContactList test
        ArrayList<User> contactList =new ArrayList<User>();

        for (int i=0; i<5;i++){
            User user = new User();
            user.setfName("Hugo");
            user.setlName("Mehdaoui");
            contactList.add(user);
        }
        //
        listContactAdapteur = new ContactAdapter(ctx, R.layout.contact_listview_view, contactList);
        myList = new ListView(ctx);
        myList.setAdapter(listContactAdapteur);

        contact = (LinearLayout) findViewById(R.id.App_layout);

        menuTop = new LinearLayout(this);
        menuBottom = new LinearLayout(this);
        mainLayout = new LinearLayout(this);

        menuTop = (LinearLayout) getLayoutInflater().inflate(R.layout.menu_top, (LinearLayout) contact.findViewById(R.id.menu_top), true);
        menuBottom = (LinearLayout) getLayoutInflater().inflate(R.layout.menu_bottom, (LinearLayout) contact.findViewById(R.id.menu_bottom), true);
        mainLayout = contact.findViewById(R.id.main_layout);
        mainLayout.addView(myList);


    }
}
