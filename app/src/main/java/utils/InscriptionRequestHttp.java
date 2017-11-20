package utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.androidlinux.projetandroid.Activity_Inscription;
import com.example.androidlinux.projetandroid.ConnexionActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
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
import java.util.ArrayList;
import java.util.Map;

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
        String retour = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.adresseIp + params[0];
        String paramPost="param={nom:"+params[1]+",prenom:"+params[2]+",login:"+params[3]+",pwd:"+params[4]+"}";
        User u = new User(params[2], params[1], params[3], params[4]);

        URL url = null;
        try {

            JSONObject jsonenvoie = new JSONObject();
            jsonenvoie.put("param", u);

            Log.d("test", "json to string" + jsonenvoie.toString());
              Log.d("test","do ibackground");
            url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setRequestProperty("Accept", "application/json");

            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(paramPost);
            writer.flush();
            //writer.close();
            int responseCode = conn.getResponseCode();
            Log.d("test", "response code" + responseCode);
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    retour += line;
                }
            } else {
                retour = "";

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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return retour;
    }

    @Override
    protected void onPostExecute(String s) {
        ViewUtils.stopProgressBar();
        Log.d("test", "onpost execute" + s);
        if (s != null) {
            Intent intent = new Intent(ctx, ConnexionActivity.class);
            intent.putExtra("connexion", s);
        }
    }

    @Override
    protected void onPreExecute() {
        Log.d("test", "onpreexecute");
        ViewUtils.startProgressDialog(ctx, "verification de l'inscription");
    }
}
