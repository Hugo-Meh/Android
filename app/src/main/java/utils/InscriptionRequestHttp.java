package utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.androidlinux.projetandroid.Activity_Inscription;
import com.example.androidlinux.projetandroid.ConnexionActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import Entities.User;
import service.C;

/**
 * Created by mohamed on 17-11-17.
 */

public class InscriptionRequestHttp extends AsyncTask<String, Long, String> {
    Context ctx;
    Activity_Inscription activity_inscription;

    public InscriptionRequestHttp(Context ctx, Activity_Inscription activity_inscription) {
        this.ctx = ctx;
        this.activity_inscription = activity_inscription;
    }

    @Override
    protected String doInBackground(String... params) {
        String retour = "";
        HttpURLConnection conn = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.adresseIp + params[0];
        User u = new User(params[2], params[1], params[3], params[4]);

        URL url = null;
        try {
            Gson gson = new Gson();
            String json = gson.toJson(u);
            url = new URL(requestURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(json);
            writer.flush();
            writer.close();
            int responseCode = conn.getResponseCode();
            Log.d("test", "response code  " + responseCode);
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    retour += line + "\n";
                }

            }
            os.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return retour;
    }

    @Override
    protected void onPostExecute(String s) {
        ViewUtils.stopProgressBar();

        if (!s.equals("")) {
            Gson gson = new Gson();
            User u = gson.fromJson(s, User.class);

            if (u.getToken().equals("-1")) {
                Toast.makeText(ctx, "Votre login est deja utilisé", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(ctx, ConnexionActivity.class);
                ctx.startActivity(intent);

            }

        } else {
            Toast.makeText(ctx, "erreur de connexion a la base de donnée", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPreExecute() {

        ViewUtils.startProgressDialog(ctx, "verification de l'inscription");
    }
}
