package utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.androidlinux.projetandroid.Bravo;
import com.example.androidlinux.projetandroid.ChoixAct;
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
 * Created by mohamed on 17-11-19.
 */

public class HttpOnStartApp extends AsyncTask<String,Long,String>{
    Context ctx;
    ConnexionActivity connexionActivity;

    public HttpOnStartApp(Context ctx, ConnexionActivity connexionActivity) {
        this.ctx = ctx;
        this.connexionActivity = connexionActivity;
    }

    @Override
    protected String doInBackground(String... params) {
        String retour="";
        HttpURLConnection conn = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.adresseIp + params[0];
        User u = new User(params[1]);

        URL url = null;
        try {

            Gson gson= new Gson();
            String s=gson.toJson(u);
            Log.d("test","json envoie ->"+s);
            url = new URL(requestURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(s);
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
        Log.d("get","on post execut   ->"+s);
        if (!s.equals("")) {
            Gson gson = new Gson();
            User u = gson.fromJson(s, User.class);

            if (!u.getToken().equals("-1")) {
                connexionActivity.SharedPreferenceSaveUser(u);
                Intent intent = new Intent(ctx, ChoixAct.class);
                intent.putExtra("token",u.getToken());
                ctx.startActivity(intent);
                connexionActivity.finish();

            } else {
                Toast.makeText(ctx, "Vous n'etes plus connecté veuillez verifier votre connexion", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ctx, "erreur de connexion a la base de donnée", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPreExecute() {

        ViewUtils.startProgressDialog(ctx, "Connexion...");
    }

}
