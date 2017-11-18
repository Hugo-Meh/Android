package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Entities.User;
import manager.UserManager;
import utils.LocalHostAdress;

public class ConnexionActivity extends AppCompatActivity {
    Context ctx;
    Button btnConnexion, btnInscription;
    EditText EditIdn, EditPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        ctx = this;
        btnConnexion = (Button) findViewById(R.id.btnConnexion);
        btnInscription = (Button) findViewById(R.id.btnInscription);
        EditIdn = (EditText) findViewById(R.id.edtIdn);
        EditPwd = (EditText) findViewById(R.id.edtPwd);

        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
            Log.d("test",ip.toString());



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }



        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(EditIdn.getText().toString(),EditPwd.getText().toString());
                UserManager.insert(ctx, user);
                Intent intent = new Intent(ctx,Bravo.class);
                startActivity(intent);
            }
        });
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ctx,Activity_Inscription.class);
                startActivity(intent);
            }
        });
    }


}
