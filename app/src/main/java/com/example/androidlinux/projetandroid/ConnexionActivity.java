package com.example.androidlinux.projetandroid;

import android.content.Context;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import Entities.User;
import utils.ConnexionRequestHttp;
import utils.Md5;
import utils.MysharedPerfermence;
public class ConnexionActivity extends AppCompatActivity {
    Context ctx;
    Button btnConnexion, btnInscription;
    EditText EditIdn, EditPwd;
    ConnexionActivity connexionActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        ctx = this;
        connexionActivity = this;
        btnConnexion = (Button) findViewById(R.id.btnConnexion);
        btnInscription = (Button) findViewById(R.id.btnInscription);
        EditIdn = (EditText) findViewById(R.id.edtIdn);
        EditPwd = (EditText) findViewById(R.id.edtPwd);
       // new MysharedPerfermence(this).removeKey("token");
        confirmToken();

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(EditIdn.getText().toString(), EditPwd.getText().toString());
                new ConnexionRequestHttp(ctx, connexionActivity).execute("connexion", user.getLogin(), Md5.md5(user.getPwd()));


            }
        });
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, Activity_Inscription.class);
                startActivity(intent);
            }
        });
    }

    public void SharedPreferenceSaveUser(User user) {
        new MysharedPerfermence(ctx, user).saveMySharedPerfermence();
    }

    public void confirmToken() {
        User user = new MysharedPerfermence(ctx).RecoverSharedPermenceUser();
        if (user != null) {
            String token=user.getToken();
            Log.d("test", token);
            if (!token.equals("")) {

               new ConnexionRequestHttp(ctx, connexionActivity).execute("verifierToken", token,null);


            }
        }

    }
}
