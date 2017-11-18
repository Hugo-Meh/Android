package com.example.androidlinux.projetandroid;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.InetAddress;
import java.net.UnknownHostException;

import utils.Md5;

public class Activity_Inscription extends AppCompatActivity {
    EditText ed_nom,ed_prenom,ed_login,ed_password;
    Button btn_inscris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__inscription);
        ed_nom= (EditText) findViewById(R.id.ed__nom_inscription);
        ed_prenom= (EditText) findViewById(R.id.ed__prenom_inscription);
        ed_login= (EditText) findViewById(R.id.ed__login_inscription);
        ed_password= (EditText) findViewById(R.id.ed__pwd_inscription);
        btn_inscris= (Button) findViewById(R.id.btn_valider_inscription);


        btn_inscris.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String nom=ed_nom.getText().toString();
                String prenom=ed_prenom.getText().toString();
                String login=ed_login.getText().toString();
                String pwd= Md5.md5(ed_password.getText().toString());
                Log.d("test","nom= "+nom+" prenom = "+prenom+ " login= "+login+"   pwd= "+pwd);
                InetAddress ip;
                try {

                    ip = InetAddress.getLocalHost();
                    Log.d("Current IP address : " ,ip.getHostAddress());

                } catch (UnknownHostException e) {

                    e.printStackTrace();

                }
            }
        });



    }
}
